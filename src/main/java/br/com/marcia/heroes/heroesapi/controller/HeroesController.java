package br.com.marcia.heroes.heroesapi.controller;

import br.com.marcia.heroes.heroesapi.document.Heroes;
import br.com.marcia.heroes.heroesapi.service.HeroesService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.marcia.heroes.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
@AllArgsConstructor
public class HeroesController {

  @NonNull
  private final HeroesService heroesService;

  @GetMapping(HEROES_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.OK)
  public Flux<Heroes> getAll() {
    log.info("Requesting the list off all heroes");
    return heroesService.findAll();
  }

  @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
  public Mono<ResponseEntity<Heroes>> findById(@PathVariable String id) {
    log.info("Requesting the hero with id {}", id);
    return heroesService.findByIdHero(id)
      .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
      .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(HEROES_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Heroes> create(@RequestBody Heroes heroes) {
    log.info("A new hero was Created");
    return heroesService.save(heroes);
  }

  @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public Mono<HttpStatus> deletebyId(@PathVariable String id) {
    heroesService.deleteByIdHero(id);
    log.info("Deleting the hero with id {}", id);
    return Mono.just(HttpStatus.NO_CONTENT);
  }

}