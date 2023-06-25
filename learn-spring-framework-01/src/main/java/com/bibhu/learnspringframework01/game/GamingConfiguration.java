package com.bibhu.learnspringframework01.game;

import com.bibhu.learnspringframework01.game.model.GameRunner;
import com.bibhu.learnspringframework01.game.model.GamingConsole;
import com.bibhu.learnspringframework01.game.model.MarioGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunner(){
        return new GameRunner(game());
    }
}
