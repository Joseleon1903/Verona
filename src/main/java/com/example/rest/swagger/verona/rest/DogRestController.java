package com.example.rest.swagger.verona.rest;

import java.util.List;
import com.example.rest.swagger.verona.model.Dog;
import com.example.rest.swagger.verona.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal/dog")
public class DogRestController {

    @Autowired
    private DogService dogService;

    @PostMapping
    public Dog create(@RequestBody Dog dog) {
        return dogService.guardar(dog);
    }

    @GetMapping
    public List<Dog> buscarTodos() {
        return dogService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(dogService.buscarPorId(id));
    }

    /*
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        dogService.delete(id);
    }
    */


}