package com.github.diogoregis.citiesapi.staties.resources;

import com.github.diogoregis.citiesapi.staties.entities.State;
import com.github.diogoregis.citiesapi.staties.repositories.StateRepository;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staties")
@Api(value="Estados")
public class StateResource {

  private final StateRepository repository;

  public StateResource(final StateRepository repository) {
    this.repository = repository;
  }

  @ApiOperation(value="Retorna lista completa com todos os EStados")
  @GetMapping
  public List<State> staties() {
    return repository.findAll();
  }
}
