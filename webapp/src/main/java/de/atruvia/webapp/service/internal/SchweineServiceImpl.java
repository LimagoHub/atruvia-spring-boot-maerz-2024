package de.atruvia.webapp.service.internal;

import de.atruvia.webapp.persistence.SchweineRepository;
import de.atruvia.webapp.service.SchweineService;
import de.atruvia.webapp.service.SchweineServiceException;
import de.atruvia.webapp.service.mapper.SchweinMapper;
import de.atruvia.webapp.service.model.Schwein;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class SchweineServiceImpl implements SchweineService {


    private final SchweineRepository repo;
    private final SchweinMapper mapper;

    @Override
    public void speichern(final Schwein schwein) {
        if(repo.existsById(schwein.getId())) throw new SchweineServiceException("GIPSSCHON");
        repo.save(mapper.convert(schwein));
    }

    @Override
    public void aendern(final Schwein schwein) {
        if(!repo.existsById(schwein.getId())) throw new SchweineServiceException("GIPSNICH");
        repo.save(mapper.convert(schwein));
    }

    @Override
    public boolean loeschen(final UUID id) {
        if(!repo.existsById(id))
            return false;
        repo.deleteById(id);
        return true;
    }

    @Override
    public Optional<Schwein> findeAnhandId(final UUID id) {
        return repo.findById(id).map(mapper::convert);
    }

    @Override
    public Iterable<Schwein> findeAlle() {
        return mapper.convert(repo.findAll());
    }

    @Override
    public boolean fuettern(final UUID id) {
        Optional<Schwein> schweinOptional = findeAnhandId(id);
        if(schweinOptional.isEmpty()) return false;
        Schwein piggy = schweinOptional.get();
        piggy.fuettern();
        aendern(piggy);
        return true;
    }
}
