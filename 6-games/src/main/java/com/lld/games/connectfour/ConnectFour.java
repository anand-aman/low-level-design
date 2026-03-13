package com.lld.games.connectfour;

import com.lld.games.Board;
import com.lld.games.Game;
import com.lld.games.model.GameState;
import com.lld.games.model.Move;
import com.lld.games.model.Player;
import com.lld.games.model.PlayingPiece;

import java.util.Scanner;

public class ConnectFour implements Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    Scanner scanner;

    public ConnectFour(){
        initializeGame();
    }

    @Override
    public void initializeGame() {
        scanner = new Scanner(System.in);
        int[] boardSize = takeBoardSizeInput();
        board = new Connect4Board(boardSize[0], boardSize[1]);
        takePlayerInput();
        currentPlayer = player1;
    }

    @Override
    public void startGame() {
        board.display();
        GameState gameState = GameState.IN_PROGRESS;
        while(gameState == GameState.IN_PROGRESS){
            Move move = takeMoveInput();
            gameState = board.makeMove(move);
            if (gameState == GameState.RETRY) {
                gameState = GameState.IN_PROGRESS;
                continue;
            }
            if (gameState==GameState.WON) {
                System.out.println("Player " + currentPlayer.getName() + " wins");
            }
            currentPlayer = player1 == currentPlayer ? player2 : player1;
            board.display();
        }
        if (gameState == GameState.DRAW) {
            System.out.println("Match Draw!");
        } else {
            System.out.println("Game ran into an issue. Please retry!");
        }
    }

    private Move takeMoveInput() {
        System.out.print("Player " + currentPlayer.getName() + "'s turn. Enter your move (column-number): ");
        int col = scanner.nextInt();
        return new Move(currentPlayer, -1, col);
    }

    private void takePlayerInput(){
        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter the name of Player " + i + ": ");
            String name = scanner.next();
            PlayingPiece pieceType = takeSymbolInput(i);
            Player player = new Player(name, pieceType);
            if(i==1)
                player1 = player;
            else
                player2 = player;
        }
    }

    private PlayingPiece takeSymbolInput(int i) {
        System.out.print("Enter piece type (X/O) for Player " + i + " : ");
        char symbol = scanner.next().charAt(0);
        PlayingPiece pieceType = PlayingPiece.fromChar(symbol);
        if (pieceType == null) {
            System.out.println("Invalid piece type. Please enter X or O.");
            return takeSymbolInput(i);
        }
        return pieceType;
    }

    @Override
    public int[] takeBoardSizeInput() {
        System.out.println("Enter the size of the game board: ");
        System.out.print("Enter Row Size: ");
        int rowSize = scanner.nextInt();
        System.out.print("Enter Column Size: ");
        int colSize = scanner.nextInt();
        if(rowSize<4 || colSize<4){
            System.out.println("Invalid Board Size. Retry.");
            return takeBoardSizeInput();
        }
        return new int[] {rowSize, colSize};
    }
}
