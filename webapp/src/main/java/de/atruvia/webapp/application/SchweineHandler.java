package de.atruvia.webapp.application;

import de.atruvia.webapp.service.model.Schwein;
import org.springframework.stereotype.Component;

import java.util.UUID;


public interface SchweineHandler {

    void handleSpeichern(Schwein schwein);
    void handleAendern(Schwein schwein);
    void handleLoeschen(UUID id);
    void handleFuettern(UUID id);

}
