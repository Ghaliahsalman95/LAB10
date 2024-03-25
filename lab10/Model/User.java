package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Entity@Table(name = "Users")
public class User {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;
    //@NotEmpty
    @Size(min =4,message = "- Length must be more than 4 characters.")
    //@Pattern(regexp = "[a-zA-z]")
   @Column(columnDefinition = "varchar(10) not null check(length(name)>4 and name Like '[a-zA-Z][a-zA-Z][a-zA-Z]')")
    private String name;
    //@NotEmpty
  @Column(columnDefinition = "varchar(30) not null unique check (email like '%_@__%.__%')")
    //@Email(message = "Email must be valid Email@com")
    private String email;
    //@NotEmpty
    @Size(min = 8,message = "Strong password is 8 length")
    @Column(columnDefinition = "varchar(10) not null check(length (password)>=8)")
    private String password;
    @NotNull(message = "age can not be null")
    @Min(value = 21,message = "age more than 21")
    @Max(value = 60,message = "age less than 60 ")
    @Column(columnDefinition = "int check(age >21 or age <60)")
    private Integer age;
    //@NotEmpty
    @Pattern(regexp = "JOB_SEEKER|EMPLOYER")
    @Column(columnDefinition = "varchar(11) not null check(role='JOB_SEEKER'or role='EMPLOYER')")
    private String role;
}
