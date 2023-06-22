package com.bibhu.learnspringframework01;

import com.bibhu.learnspringframework01.game.ContraGame;
import com.bibhu.learnspringframework01.game.GameRunner;
import com.bibhu.learnspringframework01.game.MarioGame;

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
