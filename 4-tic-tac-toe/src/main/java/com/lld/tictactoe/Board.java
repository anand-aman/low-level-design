package com.lld.tictactoe;

import lombok.Getter;

@Getter
public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }
}
