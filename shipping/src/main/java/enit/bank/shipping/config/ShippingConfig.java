package enit.bank.shipping.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = {"enit.bank.shipping","enit.bank.common.config"})
@EntityScan(basePackages = "enit.bank.shipping.domain")
@EnableJpaRepositories(basePackages = "enit.bank.shipping.repository")


@SpringBootApplication
public class ShippingConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShippingConfig.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShippingConfig.class, args);
    }
}
