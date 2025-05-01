package com.Coding.jpa.models;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {
    @Id
    @GeneratedValue

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

}
