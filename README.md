# Gerenciador de super heróis da Marvel e da DC em uma API reativa com Spring WebFlux


  - RESTful API de gerenciamento de heróis utilizando Spring WebFlux juntamente com a library reativa Reactor.
 
  - Utiliza o banco de dados DynamoDB localmente para armazenar os dados.


Spring Data DynamoDB

## Tecnologias utilizadas

  - [Java 11](https://www.oracle.com/java/)

  - [Spring Boot](https://spring.io/projects/spring-boot)
  
  - [Spring WebFlux](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html)
  
  - [Reactor](https://projectreactor.io/docs/core/release/reference/)
  
  - [Springdoc OpenAPI WebFlux UI](https://springdoc.org/)
  
  - [Amazon DynamoDB](https://aws.amazon.com/pt/dynamodb/)
  
  - [Spring Data DynamoDB](https://github.com/derjust/spring-data-dynamodb)
  
  - [AWS CLI](https://aws.amazon.com/pt/cli/)

  - [Maven](http://maven.apache.org/)

  - [Lombok](https://projectlombok.org)
  
  - [MapStruct](https://mapstruct.org/)

  - [JUnit 5](https://junit.org/junit5/)

  - [IntelliJ IDEA Community Edition](https://www.jetbrains.com/pt-br/idea/)  
  
## Passos

1. Instalar o CLI AWS 
  - [Documentação](https://docs.aws.amazon.com/pt_br/cli/latest/userguide/install-cliv2-linux.html)

2. Configurar o CLI AWS
  - [Documentação](https://docs.aws.amazon.com/pt_br/cli/latest/userguide/cli-configure-quickstart.html)

3. Instalar o DynamoDB Locally
  - [Documentação](https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)
  
4. Executar o DynamoDB local 
  - [Documentação](https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)

  - Na pasta que descompactou o DynamoDB, executar o comando:
    
    $ java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
    
  - Para visualizar as tabelas:
  
    $ aws dynamodb list-tables --endpoint-url http://localhost:8000

5. Configurar os dados de 'Access Key' e 'Secret Access Key' no arquivo **application.properties**  

6. Executar o método main da classe HeroesTable para criar a tabela

7. Executar o método main da classe HeroesData para inserir os dados iniciais na tabela  


## Swagger 

    http://localhost:8080/swagger-ui-heroes-reactive-api.html