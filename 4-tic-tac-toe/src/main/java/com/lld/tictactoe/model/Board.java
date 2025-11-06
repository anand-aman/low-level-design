package com.lld.tictactoe.model;

import lombok.Getter;

@Getter
public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
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
