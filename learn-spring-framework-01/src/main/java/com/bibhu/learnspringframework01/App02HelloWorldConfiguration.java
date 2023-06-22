package com.bibhu.learnspringframework01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {}
record Address(String city, int pinCode) {}

@Configuration
public class App02HelloWorldConfiguration {

    @Bean
    public String name() {
        return "bibhu";
    }

    @Bean
    public int age() {
        return 33;
    }

    @Bean
    public Person person() {
        return new Person("Bibhu", 33);
    }

    @Bean
    public Address address() {
        return new Address("Bangalore", 560087);
    }
}
