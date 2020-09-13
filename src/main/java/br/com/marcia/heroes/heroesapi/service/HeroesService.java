package br.com.marcia.heroes.heroesapi.service;

import br.com.marcia.heroes.heroesapi.document.Heroes;
import br.com.marcia.heroes.heroesapi.repository.HeroesRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class HeroesService {

  @NonNull
  private final HeroesRepository heroesRepository;

  public Flux<Heroes> findAll() {
    return Flux.fromIterable(heroesRepository.findAll());
  }

  public  Mono<Heroes> findByIdHero(String id) {
    return Mono.justOrEmpty(heroesRepository.findById(id));
  }

  public Mono<Heroes> save(Heroes heroes) {
    return Mono.justOrEmpty(heroesRepository.save(heroes));
  }

  public Mono<Heroes> update(String id, Heroes heroes) {

    return Mono.justOrEmpty(heroesRepository.findById(id))
            .map(existingHero -> existingHero.toBuilder()
                    .name(heroes.getName())
                    .universe(heroes.getUniverse())
                    .films(heroes.getFilms())
                    .id(heroes.getId())
                    .build())
            .map(heroesRepository::save);

  }

  public Mono<Boolean> deleteById(String id) {

    return Mono.justOrEmpty(heroesRepository.findById(id))
            .flatMap(heroes -> {
              heroesRepository.delete(heroes);
              return Mono.just(true);
            })
            .defaultIfEmpty(false);
  }

}

