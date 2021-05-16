package com.github.diogoregis.citiesapi.countries.resources;

import com.github.diogoregis.citiesapi.countries.entities.Country;
import com.github.diogoregis.citiesapi.countries.repositories.CountryRepository;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Pais")
@RestController
public class CountryResource {

  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/countries")
  @ApiOperation(value="Retorna lista completa com todos os Paises")
  public List<Country> cities() {

    return repository.findAll();
  }
}
