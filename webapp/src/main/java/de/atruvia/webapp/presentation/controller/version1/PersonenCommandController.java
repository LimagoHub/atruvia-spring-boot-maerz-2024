package de.atruvia.webapp.presentation.controller.version1;

import de.atruvia.webapp.presentation.dto.PersonDto;
import de.atruvia.webapp.presentation.mapper.PersonDtoMapper;
import de.atruvia.webapp.service.PersonenService;
import de.atruvia.webapp.service.PersonenServiceException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/v1/personen")
@RequiredArgsConstructor
public class PersonenCommandController {

    private final PersonenService service;
    private final PersonDtoMapper mapper;

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID id) throws PersonenServiceException {
        var exists = service.loeschen(id);
        if(exists)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();

    }

    @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePerson(@PathVariable UUID id, @Valid @RequestBody PersonDto dto) throws PersonenServiceException {

        if(! id.equals(dto.getId())) throw new IllegalArgumentException("Upps");

        var exists = service.aendern(mapper.convert(dto));

        if(exists)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();

    }

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertPerson(@Valid @RequestBody PersonDto dto, UriComponentsBuilder builder) throws PersonenServiceException {

        if(service.speichern(mapper.convert(dto)))
            return ResponseEntity.ok().build();
        UriComponents uriComponents = builder.path("/v1/personen/{id}").buildAndExpand(dto.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
}
