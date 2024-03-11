package de.atruvia.webapp.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonenRepository extends CrudRepository<PersonEntity, UUID> {
}
