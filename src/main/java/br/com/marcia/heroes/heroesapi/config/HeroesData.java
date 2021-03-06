package br.com.marcia.heroes.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import lombok.extern.slf4j.Slf4j;

import static br.com.marcia.heroes.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static br.com.marcia.heroes.heroesapi.constants.HeroesConstant.REGION_DYNAMO;

@Slf4j
public class HeroesData {

  public static void main(String[] args) {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder
              .EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
      .build();

    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("Heroes_Api_Table");

    log.info("Inserindo dados");

    Item hero = new Item()
      .withPrimaryKey("id", "1")
      .withString("name", "Mulher Maravilha")
      .withString("universe", "dc comics")
      .withNumber("films", 2);

    Item hero2 = new Item()
      .withPrimaryKey("id", "2")
      .withString("name", "Viúva negra")
      .withString("universe", "marvel")
      .withNumber("films", 2);

    Item hero3 = new Item()
      .withPrimaryKey("id", "3")
      .withString("name", "Capitã marvel")
      .withString("universe", "marvel")
      .withNumber("films", 2);

    PutItemOutcome outcome1 = table.putItem(hero);
    PutItemOutcome outcome2 = table.putItem(hero2);
    PutItemOutcome outcome3 = table.putItem(hero3);

  }

}

