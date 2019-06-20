/**
 * 
 */
package com.alvaroscheid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author alvaro-scheid
 *
 */

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.alvaroscheid"})
@EnableJpaRepositories(basePackages="com.alvaroscheid.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.alvaroscheid.model")
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
