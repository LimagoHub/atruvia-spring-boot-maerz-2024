package de.atruvia.webapp;


import de.atruvia.webapp.application.SchweineHandler;
import de.atruvia.webapp.service.model.MailConnector;
import de.atruvia.webapp.service.model.Schwein;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Demo {

    private final SchweineHandler handler;

    @PostConstruct
    public void init() {
        Schwein piggy = Schwein.builder().id(UUID.randomUUID()).name("Miss Piggy").gewicht(10).build();
        handler.handleSpeichern(piggy);
    }
}
