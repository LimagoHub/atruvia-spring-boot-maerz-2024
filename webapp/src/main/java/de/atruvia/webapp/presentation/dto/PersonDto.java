package de.atruvia.webapp.presentation.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {

    @NotNull
    private UUID id;

    @NotBlank
    @Size(min=2, max=30)
    private String vorname;

    @NotBlank
    @Size(min=2, max=30)
    private String nachname;
//    @DecimalMin(value = "10",inclusive = true)
//    private int alter;
}
