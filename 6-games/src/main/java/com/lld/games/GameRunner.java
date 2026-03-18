package com.lld.games;

import com.lld.games.connectfour.ConnectFour;

public class GameRunner {
    public static void main(String[] args) {
        Game connect4Game = new ConnectFour();
        connect4Game.startGame();
    }
}
