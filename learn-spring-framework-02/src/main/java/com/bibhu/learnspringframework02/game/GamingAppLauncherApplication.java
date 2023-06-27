package com.bibhu.learnspringframework02.game;

import com.bibhu.learnspringframework02.game.model.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.bibhu.learnspringframework02.game.model")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);
        context.getBean(GameRunner.class).run();

    }
}
