package de.atruvia.webapp.demo;

import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.PersonenRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class Demo {


    private final PersonenRepository repo;

    @PostConstruct
    public void init() {
//        PersonEntity toSave = PersonEntity.builder().id(UUID.randomUUID()).vorname("John").nachname("Doe").build();
//
//        repo.save(toSave);

        //repo.deleteById(UUID.fromString("cc1b0bf4-ef45-415f-ad61-93f2fbd12d0c"));

//        var liste = List.of(
//                PersonEntity.builder().id(UUID.randomUUID()).vorname("Jane").nachname("Doe").build(),
//                PersonEntity.builder().id(UUID.randomUUID()).vorname("Jane").nachname("Rambo").build(),
//                PersonEntity.builder().id(UUID.randomUUID()).vorname("Jane").nachname("McClaine").build(),
//                PersonEntity.builder().id(UUID.randomUUID()).vorname("Jane").nachname("Wick").build(),
//                PersonEntity.builder().id(UUID.randomUUID()).vorname("Jane").nachname("Wayne").build()
//        );
//
//        repo.saveAll(liste);

        //repo.projektionBesser().forEach(System.out::println);
        var p = PersonEntity.builder().id(UUID.randomUUID()).vorname("John Boy").nachname("Walton").build();

        //repo.speichern(p);
    }
}
