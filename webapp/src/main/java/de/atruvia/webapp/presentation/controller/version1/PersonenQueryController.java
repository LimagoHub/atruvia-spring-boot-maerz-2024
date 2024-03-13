package de.atruvia.webapp.presentation.controller.version1;

import de.atruvia.webapp.presentation.dto.PersonDto;
import de.atruvia.webapp.presentation.mapper.PersonDtoMapper;
import de.atruvia.webapp.service.PersonenService;
import de.atruvia.webapp.service.PersonenServiceException;
import de.atruvia.webapp.service.model.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/personen")
@RequiredArgsConstructor
public class PersonenQueryController {

    private final PersonenService service;
    private final PersonDtoMapper mapper;

    @Operation(summary = "Liefert eine Person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person gefunden",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDto.class)) }),
            @ApiResponse(responseCode = "400", description = "ungueltige ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person nicht gefunden",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content)})

    @GetMapping(path="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PersonDto> getPersonById(@PathVariable UUID id) throws PersonenServiceException {
        return ResponseEntity.of(service.findeAnhandId(id).map(mapper::convert));
    }

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PersonDto>> findAll(
            @RequestParam(required = false, defaultValue = "Otto") String vorname,
            @RequestParam(required = false, defaultValue = "Mol")String nachname
    ) throws PersonenServiceException {
        System.out.printf("Vorname = %s und nachname =%s%n", vorname, nachname);
        return ResponseEntity.ok(mapper.convert(service.findeAlle()));
    }

    @PostMapping(path="/funktionen/toupper",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)  // Ersatzget (safe, idempotent)
    public ResponseEntity<PersonDto> toUpper(@RequestBody PersonDto personDto) {
        personDto.setVorname(personDto.getVorname().toUpperCase());
        personDto.setNachname(personDto.getNachname().toUpperCase());
        return ResponseEntity.ok(personDto);
    }
}
