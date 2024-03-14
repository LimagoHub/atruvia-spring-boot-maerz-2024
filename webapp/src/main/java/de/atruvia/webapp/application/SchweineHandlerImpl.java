package de.atruvia.webapp.application;

import de.atruvia.webapp.service.SchweineService;
import de.atruvia.webapp.service.model.Schwein;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class SchweineHandlerImpl implements SchweineHandler{

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    private final SchweineService service;
    @Override
    public void handleSpeichern(final Schwein schwein) {
        service.speichern(schwein);
        applicationEventPublisher.publishEvent(new SchweinErfasstEvent(schwein));
    }

    @Override
    public void handleAendern(final Schwein schwein) {

    }

    @Override
    public void handleLoeschen(final UUID id) {

    }

    @Override
    public void handleFuettern(final UUID id) {

    }
}
