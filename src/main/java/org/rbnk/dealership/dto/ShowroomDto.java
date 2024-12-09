package org.rbnk.dealership.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ShowroomDto {
    @NotNull(message = "cannot be null")
    private Long id;

    @NotNull(message = "cannot be null")
    @Size(min = 2, max = 50, message = "The name should be between 2 and 50 characters")
    private String name;

    @NotNull(message = "cannot be null")
    @Size(min = 2, max = 100, message = "The address should be between 2 and 100 characters")
    private String address;
}
