package com.github.diogoregis.citiesapi.cities.resources;

import com.github.diogoregis.citiesapi.cities.entities.City;
import com.github.diogoregis.citiesapi.cities.repositories.CityRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="Cidades")
@RequestMapping("cities")
public class CityResource {

  private final CityRepository repository;

  public CityResource(final CityRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @ApiOperation(value="Retorna lista completa com todas as Cidades")
  public Page<City> cities(final Pageable page) {
    return repository.findAll(page);
  }
}
