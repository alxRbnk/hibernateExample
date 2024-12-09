package org.rbnk.dealership.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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
public class CarDto {
    @NotNull(message = "cannot be null")
    private Long id;

    @NotNull(message = "cannot be null")
    @Size(min = 2, max = 50, message = "The model name should be between 2 and 50 characters")
    private String model;

    @PastOrPresent(message = "The production date cannot be in the future")
    @NotNull(message = "cannot be null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate productionYear;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "price must be greater than zero")
    private Double price;
}
