package com.bibhu.learnspringframework02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass {

    private SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }

    @PostConstruct
    public void initialization() {
        someDependency.initialize();
    }

    @PreDestroy
    public void cleanUp() {
        someDependency.destroy();
    }

}

@Component
class SomeDependency {

    public void initialize() {
        System.out.println("SomeDependency initialize method");
    }

    public void destroy() {
        System.out.println("SomeDependency destroy method");
    }

}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class);

    }
}
