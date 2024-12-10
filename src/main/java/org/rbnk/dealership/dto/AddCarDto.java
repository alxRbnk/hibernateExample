package org.rbnk.dealership.dto;

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
public class AddCarDto {
    @NotNull(message = "id cannot be null")
    private Long carId;

    @NotNull(message = "id cannot be null")
    private Long showroomId;
}
