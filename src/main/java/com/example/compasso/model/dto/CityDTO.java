package com.example.compasso.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    @Length(min = 5, max = 200, message = "{name.validation.length}")
    @NotNull(message = "{name.validation.notnull}")
    private String name;

    @Length(min = 5, max = 200, message = "{state.validation.length}")
    @NotNull(message = "{state.validation.notnull}")
    private String state;
}
