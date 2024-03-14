package de.atruvia.webapp.service.configuration;

import de.atruvia.webapp.persistence.SchweineRepository;
import de.atruvia.webapp.service.SchweineService;
import de.atruvia.webapp.service.internal.SchweineServiceImpl;
import de.atruvia.webapp.service.mapper.SchweinMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchweinConfig {

    @Bean
    public SchweineService createSchweineService(final SchweineRepository repo, SchweinMapper mapper) {
        return new SchweineServiceImpl(repo,mapper);
    }
}
