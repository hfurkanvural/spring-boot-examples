package com.hfv;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Pet API Doc")
public class PetController {

    List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("My Pet");
        pet.setDate(new Date());
        petList.add(pet);
    }

    @PostMapping
    @ApiOperation(value = "New Pet create method", notes = "This method creates object immediately.")
    public ResponseEntity<Pet> create(@RequestBody @ApiParam(value = "pet") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "New Pet get method", notes = "This method gets all objects.")
    public ResponseEntity<List<Pet>> getAll(){
        return ResponseEntity.ok(petList);
    }

}
