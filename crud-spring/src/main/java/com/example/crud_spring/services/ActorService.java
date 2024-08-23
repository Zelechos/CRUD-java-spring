package com.example.crud_spring.services;

import com.example.crud_spring.models.Actor;
import com.example.crud_spring.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private IActorRepository actorRepository;

    public Actor getActorById(Integer id) {
        return actorRepository.findById(id).get();
    }

    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }

    public Actor save(Actor request){
        Actor actor = new Actor();
        actor.setActorId(request.getActorId());
        actor.setFirstName(request.getFirstName());
        actor.setLastName(request.getLastName());
        actor.setLastUpdate(LocalDateTime.now().toString());
        return actorRepository.save(actor);
    }

    public Actor put(Actor actor, Integer id ){
        Actor currentActor = actorRepository.findById(id).get();
        currentActor.setFirstName(actor.getFirstName());
        currentActor.setLastName(actor.getLastName());
        currentActor.setLastUpdate(actor.getLastUpdate());
        return actorRepository.save(currentActor);
    }

    public String remove(Integer id) {
        Actor actor = actorRepository.findById(id).get();
        actorRepository.delete(actor);
        return "ACTOR HAS DELETED SUCCESSFULLY";
    }


}
