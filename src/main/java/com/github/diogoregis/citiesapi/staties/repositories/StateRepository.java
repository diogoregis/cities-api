package com.github.diogoregis.citiesapi.staties.repositories;

import com.github.diogoregis.citiesapi.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
