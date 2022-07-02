package com.github.heloHobold.states.states.controller;

import com.github.heloHobold.states.states.model.dto.StateDto;
import com.github.heloHobold.states.states.model.entity.State;
import com.github.heloHobold.states.states.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateRepository repository;

    @GetMapping
    public List<StateDto> list(@RequestParam(required = false) String region, @PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {
        if (region == null) {
            Page<State> states = repository.findAll(pageable);
            return StateDto.convert(states);
        } else {
            Page<State> states = repository.findByRegion(region, pageable);
            return StateDto.convert(states);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDto> findById(@PathVariable Long id){
       Optional<State> optional = repository.findById(id);
        return optional.map(state -> ResponseEntity.ok(new StateDto(state))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeById(@PathVariable Long id){
        Optional<State> optional = repository.findById(id);
        if (optional.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<StateDto> add(@RequestBody @Valid StateDto stateDto){
        if (stateDto.getRegion().equalsIgnoreCase("Norte") || stateDto.getRegion().equalsIgnoreCase("Sul")
                || stateDto.getRegion().equalsIgnoreCase("Sudeste") || stateDto.getRegion().equalsIgnoreCase("Centro-Oeste")
                || stateDto.getRegion().equalsIgnoreCase("Nordeste")){
            State state = repository.save(new State(stateDto));
            return ResponseEntity.status(201).body(new StateDto(state));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateDto> updateById(@PathVariable Long id, @RequestBody @Valid StateDto upState){
        Optional<State> optional = repository.findById(id);
        if(optional.isPresent()){
            State state = repository.getReferenceById(id);
            state.setName(upState.getName());
            state.setRegion(upState.getRegion());
            state.setPopulation(upState.getPopulation());
            state.setCapital(upState.getCapital());
            state.setArea(upState.getArea());
            repository.save(state);

            return ResponseEntity.ok(new StateDto(state));
        }
        return ResponseEntity.notFound().build();
    }
}