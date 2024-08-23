package com.example.crud_spring.repositories;

import com.example.crud_spring.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create CRUD whit Spring
 *
 * @author Alex T.H.
 * @version v0.0.1
 * @since 21.0.0 2024-08-23
 */
@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
}
