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
    public ResponseEntity<List<CountryDto>> getAll() {
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
    //@GetMapping
    public ResponseEntity<List<CountryDto>> getAll(
            @RequestParam(name = "prefix", required = false) final String prefix) {

        if (Objects.isNull(prefix)) {
            return ResponseEntity.ok(countries);
        } else {

            var listOfCountries =
                            countries.stream()
                            .filter(countryDto -> countryDto.getName().startsWith(prefix))
                            .collect(Collectors.toList());
            return ResponseEntity.ok(listOfCountries);
        }
    }
    //UPDATE - PUT / PATCH
    @PutMapping("/{id}")
    public ResponseEntity<CountryDto> update(@PathVariable("id") final int id,
                                             @RequestBody final CountryDto request) {

        //find
        CountryDto countryDto = null;
        for (var country : countries) {
            if (country.getId() == id) {
                countryDto = country;
            }
        }
        //update
        if (Objects.nonNull(countryDto)) {
            countryDto.setId(request.getId());
            countryDto.setName(request.getName());
            countryDto.setPopulation(request.getPopulation());
            return ResponseEntity.ok(countryDto);
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    //DELETE - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final int id) {

        //find
        int index = -1;
        for (int i = 0; i <countries.size(); i++) {
            if (countries.get(1).getId() == id) {
                index = i;
                break;
            }
        }

        //remove
        if(index >= 0) {
            countries.remove(index);
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/hello")
    public String helloWorld()
    {
        return "hello word";
    }
}
