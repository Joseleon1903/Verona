package com.example.rest.swagger.verona.rest;

import java.util.List;
import com.example.rest.swagger.verona.model.Dog;
import com.example.rest.swagger.verona.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/animal/dog")
public class DogRestService {

    private static final org.springframework.http.HttpStatus HttpStatus = null;
    @Autowired
    private DogService dogService;

    @PostMapping
    public ResponseEntity<Dog> create(@RequestBody Dog dog) {
        return ResponseEntity.ok().body(dogService.guardar(dog));
    }

    @GetMapping
    public ResponseEntity<List<Dog>> buscarTodos() {
        return ResponseEntity.ok().body(dogService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(dogService.buscarPorId(Long.parseLong(id)));
    }

    /*
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        dogService.delete(id);
    }
    */


}