package de.atruvia.webapp.presentation.controller;

import de.atruvia.webapp.application.SchweineHandler;
import de.atruvia.webapp.presentation.dto.PersonDto;
import de.atruvia.webapp.service.model.Schwein;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.*;
import java.util.UUID;


@RestController
@RequestMapping("/demo")
@SessionScope
@RequiredArgsConstructor
public class DemoController {

    private final SchweineHandler handler;
    @GetMapping(value = "/funktionen/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
    public String gruss() {
        return "Hallo Rest";
    }

    @GetMapping(value = "/person", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> getPerson() {
        return ResponseEntity.ok(PersonDto.builder().id(UUID.randomUUID()).vorname("John").nachname("Doe").build());
    }

    @PostMapping(value = "/piggy")
    public ResponseEntity<Void> createSchwein() {
        Schwein piggy = Schwein.builder().id(UUID.randomUUID()).name("Miss Piggy").gewicht(10).build();
        handler.handleSpeichern(piggy);
        return  ResponseEntity.ok().build();
    }

}
