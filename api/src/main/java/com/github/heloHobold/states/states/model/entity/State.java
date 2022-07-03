package com.github.heloHobold.states.states.model.entity;

import com.github.heloHobold.states.states.model.dto.StateDto;
import javax.persistence.*;

@Entity
public class State {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String region;
    private int population;
    private String capital;
    private int area;

    public State() {
    }

    public State(StateDto stateDto) {
        this.id = stateDto.getId();
        this.name = stateDto.getName();
        this.region = stateDto.getRegion();
        this.population = stateDto.getPopulation();
        this.capital = stateDto.getCapital();
        this.area = stateDto.getArea();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
