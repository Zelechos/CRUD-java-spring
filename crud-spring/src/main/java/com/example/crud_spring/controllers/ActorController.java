package com.example.crud_spring.controllers;

import com.example.crud_spring.models.Actor;
import com.example.crud_spring.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping(path = "/{id}")
    public Actor getActorByPathVariable(@PathVariable("id") Integer id) {
        return actorService.getActorById(id);
    }

    @GetMapping(path = "/get")
    public Actor getActorByRequestParam(@RequestParam("id") Integer id) {
        return actorService.getActorById(id);
    }

    @GetMapping
    public List<Actor> getAll(){
       return actorService.getAllActors();
    }

    @PostMapping(path = "/save")
    public Actor save(@RequestBody Actor actor){
       return actorService.save(actor);
    }

    @PutMapping(path = "/put/{id}")
    public Actor put(@RequestBody Actor actor, @PathVariable Integer id ){
        return actorService.put(actor, id);
    }

    @DeleteMapping(path = "/remove/{id}")
    public String remove(@PathVariable Integer id){
        return actorService.remove(id);
    }

}
