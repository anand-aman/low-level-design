package com.lld.games;

import com.lld.games.model.GameState;
import com.lld.games.model.Move;

public interface Board {
    void display();
    GameState makeMove(Move move);
    boolean isWinner(Move move);
}
