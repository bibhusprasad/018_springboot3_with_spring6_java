package com.bibhu.learnspringframework01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        //01
        //Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(App02HelloWorldConfiguration.class);

        //02
        //Configure the things that we want Spring to manage -
        //App02HelloWorldConfiguration - @Configuration
        //name - @Bean

        //03
        //Retrieving Beans managed by Spring
        //String nameBean = (String)context.getBean("name");
        var nameBean = context.getBean("name");
        System.out.println(nameBean);

        //int ageBean = (int)context.getBean("age");
        var ageBean = context.getBean("age");
        System.out.println(ageBean);

        //Person personBean = (Person)context.getBean("person");
        var personBean = context.getBean("person");
        System.out.println(personBean);

        //Address addressBean = (Address) context.getBean("address");
        var addressBean = context.getBean("address");
        System.out.println(addressBean);
        
    }
}
