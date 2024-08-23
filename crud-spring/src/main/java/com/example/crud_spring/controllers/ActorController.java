package com.example.crud_spring.controllers;

import com.example.crud_spring.helpers.ApiRestFullResponses;
import com.example.crud_spring.models.Actor;
import com.example.crud_spring.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Create CRUD whit Spring
 *
 * @author Alex T.H.
 * @version v0.0.1
 * @since 21.0.0 2024-08-23
 */
@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping(path = "/{id}")
    public ApiRestFullResponses getActorByPathVariable(@PathVariable("id") Integer id) {
        return actorService.getActorById(id);
    }

    @GetMapping(path = "/get")
    public ApiRestFullResponses getActorByRequestParam(@RequestParam("id") Integer id) {
        return actorService.getActorById(id);
    }

    @GetMapping
    public ApiRestFullResponses getAll(){
       return actorService.getAllActors();
    }

    @PostMapping(path = "/save")
    public ApiRestFullResponses save(@RequestBody Actor actor){
       return actorService.save(actor);
    }

    @PutMapping(path = "/put/{id}")
    public ApiRestFullResponses put(@RequestBody Actor actor, @PathVariable Integer id ){
        return actorService.put(actor, id);
    }

    @DeleteMapping(path = "/remove/{id}")
    public ApiRestFullResponses remove(@PathVariable Integer id){
        return actorService.remove(id);
    }

}
