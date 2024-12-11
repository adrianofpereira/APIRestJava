package com.learning.controllers;


import com.learning.DTO.CountryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/country")

public class BookController {

    private List<CountryDto> countries = new ArrayList<>();
    //CREATE - POST

    //READ - GET
    @GetMapping
    public List<CountryDto> getAll()
    {
        var country = new CountryDto(1, "Brasil", 215_000_000L);
        countries.clear();
        countries.add(country);
        return countries;
    }

    //UPDATE - PUT / PATCH

    //DELETE - DELETE



    @GetMapping("/hello")
    public String helloWorld()
    {
        return "hello word";
    }
}
