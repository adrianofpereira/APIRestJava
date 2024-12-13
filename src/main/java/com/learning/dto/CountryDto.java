package com.learning.dto;

    public class CountryDto {
    private Integer id;
    private String name;
    private Long population;

    public CountryDto() {

    }

    public CountryDto(Integer id, String name, Long population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }


    @Override
    public String toString() {
        return "CountryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
