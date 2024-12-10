package org.rbnk.dealership.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    @NotNull(message = "client id cannot be null")
    private Long id;

    @NotNull(message = "client name cannot be null")
    private String name;

    private LocalDate registrationDate;
}
