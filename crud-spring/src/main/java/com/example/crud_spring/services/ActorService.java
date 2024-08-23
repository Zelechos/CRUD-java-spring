package com.example.crud_spring.services;

import com.example.crud_spring.helpers.ApiRestFullResponses;
import static com.example.crud_spring.helpers.ApiRestFullResponses.*;
import com.example.crud_spring.models.Actor;
import com.example.crud_spring.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Create CRUD whit Spring
 *
 * @author Alex T.H.
 * @version v0.0.1
 * @since 21.0.0 2024-08-23
 */
@Service
public class ActorService {

    @Autowired
    private IActorRepository actorRepository;

    public ApiRestFullResponses getActorById(Integer id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.map(value -> response("OK", 200, value))
                .orElseGet(() -> response("ERROR", 404, "ACTOR_NOT_FOUND"));
    }

    public ApiRestFullResponses getAllActors(){
        List<Actor> actors = actorRepository.findAll();
        if(actors.isEmpty()) return response("NULL", 404, "ACTORS_NOT_FOUND");
        return response("OK", 200, actors);
    }

    public ApiRestFullResponses save(Actor request){
        Actor actor = new Actor();
        actor.setActorId(request.getActorId());
        actor.setFirstName(request.getFirstName());
        actor.setLastName(request.getLastName());
        actor.setLastUpdate(LocalDateTime.now().toString());
        actorRepository.save(actor);
        return response("OK", 200, actor);
    }

    public ApiRestFullResponses put(Actor request, Integer id ){
        Optional<Actor> actorOptional = actorRepository.findById(id);

        if(actorOptional.isEmpty()) return response("ERROR", 404, "ACTOR_NOT_FOUND");

        Actor actor = actorOptional.get();

        if(request.getFirstName() != null){
            actor.setFirstName(request.getFirstName());
        }

        if(request.getLastName() != null){
            actor.setLastName(request.getLastName());
        }

        if(request.getLastUpdate() != null){
            actor.setLastUpdate(request.getLastUpdate());
        }

        actorRepository.save(actor);

        return response("OK", 200, actor);
    }

    public ApiRestFullResponses remove(Integer id) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if(actorOptional.isEmpty()) return response("ERROR", 404, "ACTOR_NOT_FOUND");
        Actor actor = actorOptional.get();
        actorRepository.delete(actor);
        return response("OK", 200, "ACTOR_HAS_DELETED_SUCCESSFULLY");
    }


}
