package com.lld.games;

import com.lld.games.model.PlayingPiece;

public interface Display {
    void displayBoard(PlayingPiece[][] grid);
    void displayMessage(String message);
}
