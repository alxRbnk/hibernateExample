package org.rbnk.dealership.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class AddReviewDto {
    @NotNull(message = "id cannot be null")
    private Long clientId;

    @NotNull(message = "id cannot be null")
    private Long carId;

    @NotNull(message = "id cannot be null")
    @NotBlank(message = "id cannot be Blank")
    private String text;

    @NotNull(message = "id cannot be null")
    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 10, message = "Rating must be at most 10")
    private Integer rating;
}
