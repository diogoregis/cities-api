package com.github.diogoregis.citiesapi.countries.repositories;

import com.github.diogoregis.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
