package com.lld.games;

import com.lld.games.model.Player;

public interface Board {
    boolean isWinner(Player player, int row, int col);

}
