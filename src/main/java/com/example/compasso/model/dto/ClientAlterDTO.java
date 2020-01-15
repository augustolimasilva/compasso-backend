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
public class ClientAlterDTO {
    @Length(min = 5, max = 100, message = "{nameClient.validation.length}")
    @NotNull(message = "{nameClient.validation.notnull}")
    private String name;
}
