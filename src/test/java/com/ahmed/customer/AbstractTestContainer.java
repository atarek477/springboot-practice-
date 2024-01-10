package com.ahmed.customer;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;


@Testcontainers
public abstract class AbstractTestContainer {
    @BeforeAll
    static void beforeAll(){

        Flyway flyway= Flyway.configure().dataSource(
                postgreSQLContainer.getJdbcUrl()
                ,postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()



        ).load();

        flyway.migrate();



    }

    @Container
    protected static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
            .withDatabaseName("ahmed-container")
            .withUsername("postgres")
            .withPassword("password");


    @Test
    void canStartPostgresDB() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
        assertThat(postgreSQLContainer.isCreated()).isTrue();

    }

    @DynamicPropertySource
    public static  void regDataSourceProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username",postgreSQLContainer::getUsername);
        registry.add("spring.datasource.url",postgreSQLContainer::getPassword);
    }
protected static DataSource getDataSource(){

        return DataSourceBuilder.create().driverClassName(postgreSQLContainer.getDriverClassName())
                .url(postgreSQLContainer.getJdbcUrl())
                .username(postgreSQLContainer.getUsername())
                .password(postgreSQLContainer.getPassword()).build();

}




}
