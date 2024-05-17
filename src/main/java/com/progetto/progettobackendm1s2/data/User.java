package com.progetto.progettobackendm1s2.data;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@Builder(setterPrefix = "with")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String fullName;
    private String email;

    public RuntimeException orElseThrow(Object o) {
        return new RuntimeException("NON SI TROVA IL CAZZO DI USER DIO PORCO");
    }
}
