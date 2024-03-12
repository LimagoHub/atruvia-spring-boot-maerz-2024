package de.atruvia.webapp.persistence;

import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.entity.TinyPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonenRepository extends CrudRepository<PersonEntity, UUID>{

    Iterable<PersonEntity> findByVorname(String vorname);
    Iterable<PersonEntity> findByVornameOrNachname(String vorname, String nachname);

    @Query("select p from PersonEntity p where p.vorname = :vorname")
    Iterable<PersonEntity> abc(String vorname);

    @Query("select p.id,  p.nachname from PersonEntity p")
    Iterable<Object[]> projektion();

    @Query("select new de.atruvia.webapp.persistence.entity.TinyPerson( p.id,  p.nachname) from PersonEntity p")
    Iterable<TinyPerson> projektionBesser();




}
