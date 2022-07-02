package com.github.heloHobold.states.states.repository;

import com.github.heloHobold.states.states.model.entity.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
    Page<State> findByRegion(String region, Pageable pageable);
}
