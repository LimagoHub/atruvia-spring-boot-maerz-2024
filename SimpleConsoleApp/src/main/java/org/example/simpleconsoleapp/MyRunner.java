package org.example.simpleconsoleapp;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.simpleconsoleapp.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {
    @Value("${MyRunner.message}")
   private final String message ;

    //@Qualifier("upper")
    private final Translator translator;

//    public MyRunner(@Value("${MyRunner.message}") final String message, @Qualifier("lower") final Translator translator) {
//        this.message = message;
//        this.translator = translator;
//    }

    @PostConstruct
    public void init() {
        System.out.println("MyRunner init");
        System.out.println(translator.translate(message));
    }
    @Override
    public void run(final String... args) throws Exception {
        System.out.println(translator.translate(message));
    }
}
