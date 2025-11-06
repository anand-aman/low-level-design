package com.lld.tictactoe.model;

public enum PieceType {
    X,
    O;

    public static PieceType fromChar(char symbol) {
        for (PieceType pieceType : PieceType.values()) {
            if (pieceType.name().charAt(0) == symbol) {
                return pieceType;
            }
        }
        return null;
    }
}
