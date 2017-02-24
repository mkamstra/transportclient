package nl.martijnkamstra.transport.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Needed for using the H2 database with Spring Data JPA in JUnit tests
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"nl.martijnkamstra.transport.models"})
@EnableJpaRepositories(basePackages = {"nl.martijnkamstra.transport.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
