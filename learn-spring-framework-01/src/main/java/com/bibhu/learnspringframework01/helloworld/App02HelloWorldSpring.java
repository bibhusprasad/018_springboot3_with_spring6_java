package com.bibhu.learnspringframework01.helloworld;

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
        //var addressBean = context.getBean("address"); //NoSuchBeanDefinitionException: No bean named 'address' available
        var addressBean = context.getBean("myAddress");
        System.out.println(addressBean);

        var addressBeanByType = context.getBean(Address.class);
        System.out.println(addressBeanByType);

        var personBeanByMethodCall = context.getBean("person2ByMethodCall");
        System.out.println(personBeanByMethodCall);

        var personBeanByParameter = context.getBean("person3ByParameter");
        System.out.println(personBeanByParameter);

    }
}
