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
public class CategoryDto {
    @NotNull(message = "id cannot be null")
    private Long id;

    @NotNull(message = "category name cannot be null")
    @Size(min = 2, max = 50, message = "The category name should be between 2 and 50 characters")
    private String name;
}
