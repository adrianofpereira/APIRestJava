package com.learning.controllers;

import com.learning.dto.CountryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/country")

public class BookController {

    private List<CountryDto> countries = insertCountries();

    private List<CountryDto> insertCountries() {
        var listOfCountries = new ArrayList<CountryDto>();
        listOfCountries.add(new CountryDto(  1,  "Brasil",  215_000_000L));
        listOfCountries.add(new CountryDto( 2,  "China",  1_400_000_000L));
        listOfCountries.add(new CountryDto(  3,  "Alemanha",  83_000_000L));
        listOfCountries.add(new CountryDto( 4,  "Argentina",  45_000_000L));
        listOfCountries.add(new CountryDto(  5,  "Chile",  25_000_000L));
        return listOfCountries;
    }

    //CREATE - POST
    @PostMapping
    public ResponseEntity<CountryDto> save(@RequestBody final CountryDto countryDto){
        countries.add(countryDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(countryDto);
    }

    //READ - GET
    @GetMapping
    public  ResponseEntity<List<CountryDto>> getAll()
    {
        var country = new CountryDto(1, "Brasil", 215_000_000L);
        countries.clear();
        countries.add(country);
        return ResponseEntity.ok(countries);
    }

    //Read Specific
    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable("id") final long id){
        for (var country: countries){
            if (country.getId() == id){
                return ResponseEntity.ok(country);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //filtering

    //UPDATE - PUT / PATCH

    //DELETE - DELETE



    @GetMapping("/hello")
    public String helloWorld()
    {
        return "hello word";
    }
}
