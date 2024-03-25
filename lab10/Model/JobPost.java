package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="JobPost")
public class JobPost {
    @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;
    //@NotEmpty
    @Size(min = 4, message = "Length must be more than 4 characters.")
    @Column(columnDefinition = "varchar(30) not null check(length(title)>4)")
    private String title;
    //@NotEmpty
    @Column(columnDefinition = "varchar(200) not null ")
    private String description;
    //@NotEmpty
    @Column(columnDefinition = "varchar(50) not null")
    private String location;
    @Positive(message = "Salary must be a non-negative number.")
    @Column(columnDefinition = "int not null check(salary>0)")
    private Integer salary;
    @Column(columnDefinition = "Data not null")
    private Date postingDate;
}
