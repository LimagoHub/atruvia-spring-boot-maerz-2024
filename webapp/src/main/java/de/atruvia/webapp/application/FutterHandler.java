package de.atruvia.webapp.application;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FutterHandler {

    @EventListener
    public void mehrFutterKaufen(SchweinErfasstEvent event) {
        System.out.println("Ich muss Futter fuer " + event.getSchwein().getName() + " kaufen");
    }
}
