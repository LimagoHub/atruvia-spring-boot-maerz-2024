package de.atruvia.webapp.service;

import de.atruvia.webapp.service.model.Schwein;

import java.util.Optional;
import java.util.UUID;

public interface SchweineService {

    void speichern(Schwein schwein);
    void aendern(Schwein schwein);
    boolean loeschen(UUID id);

    Optional<Schwein> findeAnhandId(UUID id);

    Iterable<Schwein> findeAlle();

    boolean fuettern(UUID id);
}
