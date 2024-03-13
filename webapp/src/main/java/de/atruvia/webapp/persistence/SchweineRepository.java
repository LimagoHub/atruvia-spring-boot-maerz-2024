package de.atruvia.webapp.persistence;

import de.atruvia.webapp.persistence.entity.SchweinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SchweineRepository extends CrudRepository<SchweinEntity, UUID> {

    @Query("update SchweinEntity s set s.gewicht = :gewicht where s.id=:id")
    void updateGewicht(UUID id, int gewicht);
}
