package com.lld.games.model;

public enum PlayingPiece {
    X,
    O;

    public static PlayingPiece fromChar(char symbol) {
        for (PlayingPiece pieceType : PlayingPiece.values()) {
            if (pieceType.name().charAt(0) == symbol) {
                return pieceType;
            }
        }
        return null;
    }
}
