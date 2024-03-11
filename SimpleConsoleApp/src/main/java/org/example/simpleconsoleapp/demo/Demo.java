package org.example.simpleconsoleapp.demo;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//import javax.inject.Named;

@Component
//@Lazy
//@Scope("singleton")  // Default
@Scope("prototype")  // Default
public class Demo {

    public Demo() {
        System.out.println("Ctor von Demo");
    }

    @PostConstruct
    private void init() {
        System.out.println("Postconstruct von Demo");
    }

    @PreDestroy
    private void dispose() {
        System.out.println(".... und Tschuess");
    }
}
