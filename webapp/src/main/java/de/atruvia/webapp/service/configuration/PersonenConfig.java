package de.atruvia.webapp.service.configuration;


import de.atruvia.webapp.persistence.PersonenRepository;
import de.atruvia.webapp.service.PersonenService;
import de.atruvia.webapp.service.internal.PersonenServiceImpl;
import de.atruvia.webapp.service.mapper.PersonenMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonenConfig {


    @Bean
    @Qualifier("antipathen")
    public List<String> createAntipathen() {
        return List.of("Attila","Peter","Paul", "Mary");
    }

    @Bean
    @Qualifier("fruits")
    public List<String> createFruits() {
        return List.of("Apple","Banana","Cherry", "Strawberry");
    }

//    @Bean
//    public PersonenService createPersonenService(PersonenRepository repo, PersonenMapper mapper,@Qualifier("antipathen") List<String> antipathen ) {
//        return new PersonenServiceImpl(repo, mapper, antipathen);
//    }
}
