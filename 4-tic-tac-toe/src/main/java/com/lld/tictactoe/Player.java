package com.lld.tictactoe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private String name;
    private PlayingPiece playingPiece;
}
