package com.example.crud_spring.repositories;

import com.example.crud_spring.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
}
