package de.atruvia.webapp.service.internal;

import de.atruvia.webapp.aspects.Dozent;
import de.atruvia.webapp.persistence.PersonenRepository;
import de.atruvia.webapp.service.BlacklistService;
import de.atruvia.webapp.service.PersonenService;
import de.atruvia.webapp.service.PersonenServiceException;
import de.atruvia.webapp.service.mapper.PersonenMapper;
import de.atruvia.webapp.service.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {PersonenServiceException.class}, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PersonenServiceImpl implements PersonenService {

    private final PersonenRepository repo;
    private final PersonenMapper mapper;
    //private final BlacklistService blacklistService;

    @Qualifier("antipathen")
    private final List<String> antipathen;

//    void bulkInsert(List<Person> personen) throws PersonenServiceException{
//       for(var person: personen)
//           speichern(person);
//    }

    /*
            Parameter null -> PSE
            vorname null -> PSE
            vorname zu kurz -> PSE
            nachname null -> PSE
            nachname zu kurz -> PSE
            Attila -> PSE
            runtimeException -> PSE
            happy day -> person wird an repo übergeben
         */
    @Override
    @Transactional(rollbackFor = {PersonenServiceException.class}, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public boolean speichern(final Person person) throws PersonenServiceException {
        try {
            return speichernImpl(person);
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Upps",e);
        }
    }

    private boolean speichernImpl(final Person person) throws PersonenServiceException {

        checkPerson(person);
        if(repo.existsById(person.getId())) return true;
        repo.save(mapper.convert(person));
        return false;
    }

    private void checkPerson(final Person person) throws PersonenServiceException {
        validatePerson(person);

        businessCheck(person);
    }

    private void businessCheck(final Person person) throws PersonenServiceException {
        if(antipathen.contains(person.getVorname()))
            throw new PersonenServiceException("Antipath");
    }

    private static void validatePerson(final Person person) throws PersonenServiceException {
        if(person == null)
            throw new PersonenServiceException("Parameter darf nicht null sein");

        if(person.getVorname() == null || person.getVorname().length() < 2)
            throw new PersonenServiceException("Vorname zu kurz");

        if(person.getNachname() == null || person.getNachname().length() < 2)
            throw new PersonenServiceException("Nachname zu kurz");
    }

    @Override
    public boolean aendern(final Person person) throws PersonenServiceException {
        speichern(person);
        return true;
    }

    @Override
    public boolean loeschen(final UUID id) throws PersonenServiceException {
        try {
            boolean result = repo.existsById(id);
            if (!result) {
                return false;
            }
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new PersonenServiceException("Upps", e);
        }
    }

    @Transactional(rollbackFor = {PersonenServiceException.class} ,isolation = Isolation.READ_UNCOMMITTED)

    @Override
    public Optional<Person> findeAnhandId(final UUID id) throws PersonenServiceException {
        try {
            return repo.findById(id).map(mapper::convert);
        }catch (Exception e) {
            throw new PersonenServiceException("Upps", e);
        }
    }

    @Override
    public Iterable<Person> findeAlle() throws PersonenServiceException {
        try {
            return mapper.convert(repo.findAll());
        } catch (Exception e) {
            throw new PersonenServiceException("Upps", e);
        }
    }
}
