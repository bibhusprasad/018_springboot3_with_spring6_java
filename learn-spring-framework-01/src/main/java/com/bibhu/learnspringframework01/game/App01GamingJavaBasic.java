package com.bibhu.learnspringframework01.game;

import com.bibhu.learnspringframework01.game.model.ContraGame;
import com.bibhu.learnspringframework01.game.model.GameRunner;
import com.bibhu.learnspringframework01.game.model.MarioGame;

public class App01GamingJavaBasic {

    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
        var contraGame = new ContraGame();
        gameRunner = new GameRunner(contraGame);
        gameRunner.run();

    }
}
