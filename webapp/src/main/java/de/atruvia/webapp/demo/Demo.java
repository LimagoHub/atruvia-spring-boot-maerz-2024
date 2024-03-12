package de.atruvia.webapp.demo;

import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.PersonenRepository;
import de.atruvia.webapp.service.PersonenService;
import de.atruvia.webapp.service.PersonenServiceException;
import de.atruvia.webapp.service.model.Person;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class Demo {


    private final PersonenService service;

    @PostConstruct
    public void init() {
        try {
            var  attila = Person.builder().id(null).vorname("Attila").nachname("Doe").build();
            service.speichern(attila);
        } catch (PersonenServiceException e) {
            e.printStackTrace();
        }

    }


}
