package com.Coding.jpa.models.embedded;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Adress {

    private String streetName;
    private String houseNumber;
    private String ZipCode;

}
