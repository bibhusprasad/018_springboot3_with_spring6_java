package com.bibhu.learnspringframework01.game;

import com.bibhu.learnspringframework01.game.model.ContraGame;
import com.bibhu.learnspringframework01.game.model.GameRunner;
import com.bibhu.learnspringframework01.game.model.GamingConsole;
import com.bibhu.learnspringframework01.game.model.MarioGame;
import com.bibhu.learnspringframework01.helloworld.App02HelloWorldConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingSpringBean {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);
        var game = (GamingConsole)context.getBean("game");
        game.up();

        var gameRunner = (GameRunner)context.getBean("gameRunner");
        gameRunner.run();

    }
}
