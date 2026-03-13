package com.lld.games.connectfour;

import com.lld.games.Game;
import com.lld.games.model.Player;

import java.util.Scanner;

public class ConnectFour implements Game {

    private Connect4Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public ConnectFour(){
        initializeGame();
    }

    @Override
    public void initializeGame() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public int[] takeBoardSizeInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the game board: ");
        System.out.print("Enter Row Size: ");
        int row = scanner.nextInt();
        System.out.print("Enter Column Size: ");
        int col = scanner.nextInt();
        return new int[] {row, col};
    }
}
