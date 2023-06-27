package com.bibhu.learnspringframework02;

import jakarta.inject.Inject;
import jakarta.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;

//@Component
@Named
class BusinessService {
    private DataService dataService;

    //@Autowired
    @Inject
    public void setDataService(DataService dataService){
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return this.dataService;
    }


}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class);
    }
}
