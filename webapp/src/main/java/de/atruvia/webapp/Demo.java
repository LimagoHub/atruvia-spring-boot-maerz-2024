package de.atruvia.webapp;


import de.atruvia.webapp.service.model.MailConnector;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Demo {

    private final MailConnector connector;

    @PostConstruct
    public void init() {
        System.out.println(connector);
    }
}
