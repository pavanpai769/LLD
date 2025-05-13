package com.tictactoe.model;

public abstract class PlayingPiece {
    protected PlayingPiecesType type;

    protected PlayingPiece(PlayingPiecesType type) {
        this.type = type;
    }

    public PlayingPiecesType getType() {
        return type;
    }

    public boolean equals(PlayingPiece piece) {
        return type == piece.getType();
    }

    public String toString() {
        return type.toString();
    }
}
