package com.github.diogoregis.citiesapi.cities.resources;

import com.github.diogoregis.citiesapi.cities.service.DistanceService;
import com.github.diogoregis.citiesapi.cities.service.EarthRadius;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="Distancia")
@RequestMapping("/distances")
public class DistanceResource {

  private final DistanceService service;
  Logger log = LoggerFactory.getLogger(DistanceResource.class);

  public DistanceResource(DistanceService service) {
    this.service = service;
  }

  @ApiOperation(value="Retorna distancia entre cidades baseado no POINT, em milhas")
  @GetMapping("/by-points")
  public Double byPoints(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
    log.info("byPoints");
    return service.distanceByPointsInMiles(city1, city2);
  }

  @ApiOperation(value="Retorna distancia entre duas cidades, baseado no calculo CUBE, em metros")
  @GetMapping("/by-cube")
  public Double byCube(@RequestParam(name = "from") final Long city1,
                       @RequestParam(name = "to") final Long city2) {
    log.info("byCube");
    return service.distanceByCubeInMeters(city1, city2);
  }

  @ApiOperation(value="Retorna distancia, escolhendo uma unidade METROS, QUILOMETROS e MILHAS")
  @GetMapping("/by-math")
  public Double byMath(@RequestParam(name = "from") final Long city1,
                       @RequestParam(name = "to") final Long city2,
                       @RequestParam final EarthRadius unit) {
    log.info("byMath");
    return service.distanceUsingMath(city1, city2, unit);
  }
}
