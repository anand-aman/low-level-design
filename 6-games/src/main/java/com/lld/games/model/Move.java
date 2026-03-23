package com.lld.games.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Move {
    Player player;
    int row;
    int col;
}
