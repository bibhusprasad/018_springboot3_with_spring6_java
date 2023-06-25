package com.bibhu.learnspringframework01.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {}
record Address(String city, int pinCode) {}

@Configuration
public class App02HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ankita";
    }

    @Bean
    public int age() {
        return 27;
    }

    @Bean
    public Person person() {
        return new Person("Bibhu", 33);
    }

    @Bean (name = "myAddress")
    public Address address() {
        return new Address("Bangalore", 560087);
    }

    @Bean
    public Person person2ByMethodCall() {
        return new Person(name(), age());
    }

    @Bean
    public Person person3ByParameter(String name, int age) {
        return new Person(name, age);
    }
}
