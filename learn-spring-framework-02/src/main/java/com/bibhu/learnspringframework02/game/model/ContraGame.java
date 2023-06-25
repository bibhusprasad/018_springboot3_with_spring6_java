package com.bibhu.learnspringframework02.game.model;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ContraGameQualifier")
public class ContraGame implements GamingConsole {

    public void up() {
        System.out.println("Contra Jump");
    }

    public void down() {
        System.out.println("Contra down");
    }

    public void left() {
        System.out.println("Contra left");
    }

    public void right() {
        System.out.println("Contra right");
    }

}
