# FILMES API

**Informações importantes**

*Configurações necessária de ambiente*

 - JDK 8 (Java)
 - Maven
 - IDE de preferencia configurada com o [Lombok](https://projectlombok.org/)

*Para rodar a API*

 - 'mvn test' para rodar apenas os testes.
  Necessario ter um servidor de aplicação.
    
    > Recomendação: wildfly 18.
    No standalone.xml adicionar: 
    ```
    <datasource jndi-name="java:jboss/datasources/FilmeDS" pool-name="FilmeDS" enabled="true" use-java-context="true"           statistics-enabled="true">
            <connection-url>jdbc:h2:mem:filmeDB;MODE=ORACLE;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
                <driver>h2</driver>
                <security>
                    <user-name>sa</user-name>
                    <password>sa</password>
                </security>
    </datasource>
    ```

