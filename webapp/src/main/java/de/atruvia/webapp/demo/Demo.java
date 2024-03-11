package de.atruvia.webapp.demo;

import de.atruvia.webapp.persistence.PersonEntity;
import de.atruvia.webapp.persistence.PersonenRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Demo {


    private final PersonenRepository repo;

    @PostConstruct
    public void init() {
        PersonEntity toSave = PersonEntity.builder().id(UUID.randomUUID()).vorname("John").nachname("Doe").build();

        repo.save(toSave);
    }
}
