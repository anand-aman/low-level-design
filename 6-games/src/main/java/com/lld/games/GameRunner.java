package com.lld.games;

import com.lld.games.connectfour.ConnectFour;

public class GameRunner {
    public static void main(String[] args) {
        Game game = new ConnectFour();
        game.startGame();
    }
}
