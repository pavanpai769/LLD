package com.tictactoe.model;

import com.tictactoe.model.piece.PlayingPiece;

import java.util.Arrays;

public class Board {
    private PlayingPiece[][] grid;

    public Board(int sizeOfTheBoard) {
        grid = new PlayingPiece[sizeOfTheBoard][sizeOfTheBoard];
    }

    public void placePiece(int x, int y, PlayingPiece piece) {
        grid[x][y] = piece;
    }

    public boolean isValidMove(int x, int y) {
        return this.grid[x][y] == null;
    }

    public PlayingPiece[][] getGrid() {
        return grid;
    }


    public boolean validateWinner(PlayingPiece playingPiece) {
        return  validateRow(playingPiece) || validateColumn(playingPiece) || validateDiagonal(playingPiece);
    }

    private boolean validateDiagonal(PlayingPiece playingPiece) {
        boolean valid = true;

        // check principal diagonal
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][i] == null || !grid[i][i].equals(playingPiece) ){
                valid = false;
                break;
            }
        }
        if(valid) {
            return true;
        }
        valid = true;
        //check secondary diagonal
        for(int i = 0; i < grid.length; i++) {
            PlayingPiece currPiece = grid[i][grid.length-1-i];
            if(currPiece == null || !currPiece.equals(playingPiece)) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    private boolean validateColumn(PlayingPiece playingPiece) {
        outer:
        for(int col = 0; col < grid[0].length; col++) {
            for(int row = 0; row < grid.length; row++) {
                if(grid[row][col] == null || ! playingPiece.equals(grid[row][col])) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }

    private boolean validateRow(PlayingPiece playingPiece) {
        for(PlayingPiece[] row : grid){
            if(Arrays.stream(row)
                    .allMatch(piece -> piece != null && piece.equals(playingPiece))
            ){
                return true;
            }

        }
        return false;
    }

    public boolean isFull() {
        for(PlayingPiece[] row : grid) {
            for(PlayingPiece piece : row) {
                if(piece == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for(PlayingPiece[] row : grid) {
            Arrays.fill(row, null);
        }
    }
}
