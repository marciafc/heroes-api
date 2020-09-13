package br.com.marcia.heroes.heroesapi;

import br.com.marcia.heroes.heroesapi.repository.HeroesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesApiApplicationTests {

	public static final String HEROES_ENDPOINT_LOCAL = "/heroes";

	@Autowired
	WebTestClient webTestClient;

	@Test
	public void getOneHeroeById(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"2")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneHeroNotFound(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"100")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteHero(){
		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"2")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}

}