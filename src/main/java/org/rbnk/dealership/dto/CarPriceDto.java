package org.rbnk.dealership.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarPriceDto {
    @NotNull(message = "cannot be null")
    private Long id;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "price must be greater than zero")
    private Double price;
}
