package org.rbnk.dealership.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.rbnk.dealership.entity.Car;
import org.rbnk.dealership.entity.Client;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    @NotNull(message = "id cannot be null")
    private Long id;

    @NotNull(message = "text cannot be null")
    private String text;

    @NotNull(message = "rating cannot be null")
    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 10, message = "Rating must be at most 10")
    private int rating;

    @NotNull(message = "car cannot be null")
    private Car car;

    @NotNull(message = "client cannot be null")
    private Client client;
}
