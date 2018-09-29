package com.microfocus.entcounion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Email(regexp="@hpe.com")
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String id;

}
