package de.atruvia.webapp.presentation.mapper;

import de.atruvia.webapp.presentation.dto.PersonDto;
import de.atruvia.webapp.service.model.Person;
import org.mapstruct.Mapper;
import static org.mapstruct.MappingConstants.ComponentModel.*;
@Mapper(componentModel = SPRING)
public interface PersonDtoMapper {
    PersonDto convert(Person person);
    Person convert(PersonDto personDto);

    Iterable<PersonDto> convert(Iterable<Person> personen);
}
