package com.bibhu.learnspringframework01.game.model;

public class MarioGame implements GamingConsole{

    public void up() {
        System.out.println("Mario Jump");
    }

    public void down() {
        System.out.println("Mario down");
    }

    public void left() {
        System.out.println("Mario left");
    }

    public void right() {
        System.out.println("Mario right");
    }
}
