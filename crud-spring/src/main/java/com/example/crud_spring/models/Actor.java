package com.example.crud_spring.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Create CRUD whit Spring
 *
 * @author Alex T.H.
 * @version v0.0.1
 * @since 21.0.0 2024-08-23
 */
@Data
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    private String lastUpdate;

}
