package com.example.compasso.model.dto;

import com.example.compasso.model.City;
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

    @Length(min = 5, max = 20, message = "{sex.validation.length}")
    @NotNull(message = "{sex.validation.notnull}")
    private String sex;

    @Pattern(regexp = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$", message = "{birthday.validation.formato}")
    private String birthday;

    @NotNull(message = "{age.validation.notnull}")
    @Digits(integer = 3, fraction = 0, message = "{age.validation.digits}")
    private int age;

    private City cidade;
}
