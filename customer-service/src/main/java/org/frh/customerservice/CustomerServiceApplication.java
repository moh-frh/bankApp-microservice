package org.frh.customerservice;

import org.frh.customerservice.config.GlobalConfig;
import org.frh.customerservice.entity.Customer;
import org.frh.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    private final CustomerRepository customerRepository;

    public CustomerServiceApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            List<Customer> customerList = List.of(
                Customer.builder()
                        .firstName("mohamed")
                        .lastName("frh")
                        .email("mohamed@gmail.com")
                        .build(),

                Customer.builder()
                        .firstName("sofi")
                        .lastName("frt")
                        .email("sofi@gmail.com")
                        .build()
            );

            customerRepository.saveAll(customerList);
        };
    }
}
