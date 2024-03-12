package de.atruvia.webapp.service.internal;

import de.atruvia.webapp.persistence.PersonenRepository;
import de.atruvia.webapp.service.PersonenServiceException;
import de.atruvia.webapp.service.mapper.PersonenMapper;
import de.atruvia.webapp.service.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PersonenServiceImplTest {

    @InjectMocks
    private PersonenServiceImpl objectUnderTest;

    @Mock
    private PersonenRepository repoMock;

    @Mock
    private PersonenMapper mapperMock;

    @Test
    @DisplayName("speichern mit leerem Parameter erwartet eine throws_PersonenServiceException")
    void speichernParameterNull() throws Exception {
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(null));
        assertEquals("Parameter darf nicht null sein", ex.getMessage());
    }

    @Test
    void speichern__vorname_is_null__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname(null).nachname("Doe").build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Vorname zu kurz", ex.getMessage());
    }

    @Test
    void speichern__vorname_is_to_short__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname("J").nachname("Doe").build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Vorname zu kurz", ex.getMessage());
    }

    @Test
    void speichern__nachname_is_null__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname("John").nachname(null).build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Nachname zu kurz", ex.getMessage());
    }
    @Test
    void speichern__nachname_is_to_short__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname("John").nachname("D").build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Nachname zu kurz", ex.getMessage());
    }

    @Test
    void speichern__unerwuenschte_person__throws_PersonenServiceException() throws Exception {
        final Person attila = Person.builder().id(null).vorname("Attila").nachname("Doe").build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(attila));
        assertEquals("Antipath", ex.getMessage());
    }


}