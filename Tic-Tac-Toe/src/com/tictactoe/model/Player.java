package com.tictactoe.model;

import javax.swing.text.Position;

public class Player {
    private final String name;
    private PlayingPiece playingPiece;

    public Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public Player(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) throws IllegalAccessException,IllegalArgumentException {
        if(this.playingPiece != null){
            throw new IllegalAccessException("This playing piece is already set");
        }else if(playingPiece == null){
            throw new IllegalArgumentException("This playing piece is null");
        }
        this.playingPiece = playingPiece;
    }
}
