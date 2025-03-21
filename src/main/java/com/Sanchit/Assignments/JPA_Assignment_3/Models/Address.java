package com.Sanchit.Assignments.JPA_Assignment_3.Models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//q1
@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String streetNumber;
    private String location;
    private String state;


    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", location='" + location + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
