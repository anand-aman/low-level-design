package com.lld.games.connectfour;

import com.lld.games.Board;
import com.lld.games.model.Player;
import com.lld.games.model.PlayingPiece;

public class Connect4Board implements Board {
    private PlayingPiece[][] grid;

    @Override
    public boolean isWinner(Player player, int row, int col) {
        return false;
    }
}
