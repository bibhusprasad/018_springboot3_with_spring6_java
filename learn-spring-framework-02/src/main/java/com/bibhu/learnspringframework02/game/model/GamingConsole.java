package com.bibhu.learnspringframework02.game.model;

import org.springframework.stereotype.Component;

@Component
public interface GamingConsole {

    void up();
    void down();
    void left();
    void right();

}
