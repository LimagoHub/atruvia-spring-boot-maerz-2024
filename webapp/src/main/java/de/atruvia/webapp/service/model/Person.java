package de.atruvia.webapp.service.model;



import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Setter(AccessLevel.PRIVATE)
    private UUID id;


    private String vorname;


    private String nachname;
}
