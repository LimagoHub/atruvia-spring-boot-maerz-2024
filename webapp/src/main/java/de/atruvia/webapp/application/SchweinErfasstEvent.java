package de.atruvia.webapp.application;

import de.atruvia.webapp.service.model.Schwein;
import org.springframework.context.ApplicationEvent;

public class SchweinErfasstEvent {

    private final Schwein schwein;

    public SchweinErfasstEvent(final Schwein schwein) {

        this.schwein = schwein;
    }

    public Schwein getSchwein() {
        return schwein;
    }
}
