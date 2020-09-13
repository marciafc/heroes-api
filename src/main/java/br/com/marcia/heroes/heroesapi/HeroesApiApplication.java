package br.com.marcia.heroes.heroesapi;

import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
@Slf4j
public class HeroesApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(HeroesApiApplication.class, args);

		log.info("Super poderes com WebFlux");
	}

}
