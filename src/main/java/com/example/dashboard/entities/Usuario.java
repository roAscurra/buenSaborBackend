package com.example.dashboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Usuario extends Base{
    @Column(name = "auth0Id")
    private String auth0Id;
    @Column(name = "username")
    private String username;
}
