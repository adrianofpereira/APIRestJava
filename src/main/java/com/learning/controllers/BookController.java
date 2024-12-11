package com.learning.controllers;


import com.learning.DTO.CountryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/country")

public class BookController {

    private List<CountryDto> countries = new ArrayList<>();
    //CREATE - POST
    @PostMapping
    public CountryDto save(@RequestBody final CountryDto countryDto){
        countries.add(countryDto);
        return countryDto;
    }

    //READ - GET
    @GetMapping
    public List<CountryDto> getAll()
    {
        var country = new CountryDto(1, "Brasil", 215_000_000L);
        countries.clear();
        countries.add(country);
        return countries;
    }

    //Read Sspecific
    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable("id") final long id){
        for (var country: countries){
            if (country.getId() == id){
                return ResponseEntity.ok(country);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //UPDATE - PUT / PATCH

    //DELETE - DELETE



    @GetMapping("/hello")
    public String helloWorld()
    {
        return "hello word";
    }
}
