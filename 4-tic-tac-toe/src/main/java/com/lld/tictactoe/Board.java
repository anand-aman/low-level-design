package com.lld.tictactoe;

import com.lld.tictactoe.model.PieceType;
import com.lld.tictactoe.model.Player;
import com.lld.tictactoe.model.PlayingPiece;
import lombok.Getter;

@Getter
public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean isWinner(Player player, int row, int column) {

        PieceType pieceType = player.getPlayingPiece().getPieceType();

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0; i<size; i++) {
            if(board[row][i] == null || board[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0; i<size; i++) {

            if(board[i][column] == null || board[i][column].getPieceType() != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<size; i++,j++) {
            if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=size-1; i<size; i++,j--) {
            if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType().name() + " ");
                } else {
                    System.out.print("  ");
                }
                if (j != size - 1)
                    System.out.print(" | ");
            }
            if (i != size-1){
                System.out.println();
                System.out.println("--- --- --- ");
            } else {
                System.out.println();
            }

        }
    }
}
