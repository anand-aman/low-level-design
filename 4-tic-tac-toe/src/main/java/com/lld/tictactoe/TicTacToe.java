package com.lld.tictactoe;

import com.lld.tictactoe.model.Board;
import com.lld.tictactoe.model.PieceType;
import com.lld.tictactoe.model.Player;
import com.lld.tictactoe.model.PlayingPiece;
import lombok.Setter;

import java.util.*;

@Setter
public class TicTacToe {
    private Deque<Player> players;
    private Board board;
    private Scanner scanner;

    public void initializeGame() {
        scanner = new Scanner(System.in);
        players = new LinkedList<>();
        board = new Board(3);

        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter the name of Player " + i + ": ");
            String name = scanner.next();
            PieceType pieceType = takeSymbolInput(i);
            Player player = new Player(name, new PlayingPiece(pieceType));
            players.add(player);
        }

    }

    public void startGame() {
        boolean nowWinner = true;
        while(nowWinner) {
            Player player = players.removeFirst();
            System.out.print("Player " + player.getName() + "'s turn. Enter your move (row,column): ");
            String coordinatesInput = scanner.next();
            String[] coordinates = coordinatesInput.split(",");
            int row = Integer.parseInt(coordinates[0]);
            int col = Integer.parseInt(coordinates[1]);

            if (row>=board.getSize() || col>= board.getSize() || board.getBoard()[row][col] != null) {
                System.out.println("Invalid move. Try again.");
                players.addFirst(player);
            }
            else {
                board.getBoard()[row][col] = player.getPlayingPiece();
                board.printBoard();
                if (isWinner(player, row, col)) {
                    System.out.println("Player " + player.getName() + " wins!");
                    nowWinner = false;
                    continue;
                }
                players.addLast(player);
            }

        }


    }


    private boolean isWinner(Player player, int row, int column) {

        PlayingPiece[][] gameBoard = board.getBoard();
        PieceType pieceType = player.getPlayingPiece().getPieceType();

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0; i<board.getSize(); i++) {
            if(gameBoard[row][i] == null || gameBoard[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0; i<board.getSize(); i++) {

            if(gameBoard[i][column] == null || gameBoard[i][column].getPieceType() != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.getSize(); i++,j++) {
            if (gameBoard[i][j] == null || gameBoard[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.getSize()-1; i<board.getSize(); i++,j--) {
            if (gameBoard[i][j] == null || gameBoard[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


    private PieceType takeSymbolInput(int i) {
        System.out.print("Enter piece type (X/O) for Player " + i + " : ");
        char symbol = scanner.next().charAt(0);
        PieceType pieceType = PieceType.fromChar(symbol);
        if (pieceType == null) {
            System.out.println("Invalid piece type. Please enter X or O.");
            return takeSymbolInput(i);
        }
        return pieceType;
    }

}
