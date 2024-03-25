package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@Data@NoArgsConstructor
@Entity@Table(name="JobApplication")
public class JobApplication {
    @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;
    @NotNull(message = "userID cant be null")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @NotNull @Column(columnDefinition = " int not null")
    private Integer job_postID;




}
