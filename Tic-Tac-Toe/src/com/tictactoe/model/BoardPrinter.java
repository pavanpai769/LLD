package com.tictactoe.model;

import com.tictactoe.model.piece.PlayingPiece;

import java.util.Arrays;
public class BoardPrinter {

    private final String board = """
              
                
                       |       |
                   %s   |   %s   |   %s
                _______|_______|_______
                       |       |
                   %s   |   %s   |   %s
                _______|_______|_______
                       |       |
                   %s   |   %s   |   %s
                       |       |
                
                """;


    public String printBoard(PlayingPiece[][] board) {
        String[] flattenBoard = Arrays.stream(board)
                .flatMap(Arrays::stream)
                .map(playingPiece -> playingPiece== null ? "":playingPiece.toString())
                .toArray(String[]::new);

        for(int i = 0; i < flattenBoard.length; i++) {
            if(flattenBoard[i].isEmpty()) {
                flattenBoard[i] = i+1+"";
            }
        }

        return this.board.formatted((Object[]) flattenBoard);
    }
}
