package com.example.compasso.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @Length(min = 5, max = 100, message = "{nameClient.validation.length}")
    @NotNull(message = "{nameClient.validation.notnull}")
    private String name;

    @Length(min = 5, max = 20, message = "{gender.validation.length}")
    @NotNull(message = "{gender.validation.notnull}")
    private String gender;

    @Pattern(regexp = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$", message = "{birthday.validation.format}")
    private String birthday;

    @Digits(integer = 3, fraction = 1, message = "{age.validation.digits}")
    private int age;

    private CityOfClientDTO city;
}
