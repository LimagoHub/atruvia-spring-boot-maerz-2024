package org.example.simpleconsoleapp.translator;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("upper")
@Profile("production")
public class ToUpperTranslator implements Translator{
    @Override
    public String translate(final String message) {
        return message.toUpperCase();
    }
}
