package com.tictactoe.model;

import java.util.*;

public class Game {
    private final Board board;
    private Deque<Player> players;
    private final BoardPrinter printer;

    private final HashMap<Integer,int[]> numberToIndexMap = new HashMap<>();

    {
        int number = 1;

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                numberToIndexMap.put(number++, new int[]{i,j});
            }
        }
    }

    public Game() {
        board = new Board(3);
        players = new LinkedList<>();
        printer = new BoardPrinter();
    }

    public void addPlayer(Player player) throws IllegalArgumentException, IllegalStateException {
        if(player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        } else if( player.getPlayingPiece() == null) {
            throw new IllegalStateException("Player has no playing piece.");
        }
        else if (players.stream()
                .anyMatch(player1 -> player1.getPlayingPiece()
                        .equals(player.getPlayingPiece())
                )
        ) {
            throw new IllegalArgumentException("player with playing pieces type already exists");
        }
        players.add(player);
    }

    public String startGame() throws IllegalStateException{
        if(players.size() < 2) {
            throw new IllegalStateException("Game requires at least two players");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(printer.printBoard(board.getGrid()));
        while(true) {

            if(board.isFull()){
                return "Game over";
            }
            Player currentPlayer = players.poll(); // remove the first player from queue
            players.add(currentPlayer);  // add to last

            System.out.println("Turn: " + currentPlayer.getName());

            while(true)  {
                System.out.println("Hey, "+currentPlayer.getName()+ " please select the cell number");
                int cell = 0;
                try{
                    cell = scanner.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("please enter valid a number (1-9) ");
                }
                if(cell <1 || cell > 9){
                    System.out.println("Invalid cell number.");
                    continue;
                }
                int[] position = numberToIndexMap.get(cell);
                int row = position[0];
                int col = position[1];

                if(!board.isValidMove(row, col)) {
                    System.out.println("Invalid move.Try Again");
                    continue;
                }

                board.placePiece(row,col,currentPlayer.getPlayingPiece());
                break;
            }

            System.out.println(printer.printBoard(board.getGrid()));

            if(board.validateWinner(currentPlayer.getPlayingPiece())) {
                board.clear();
                return currentPlayer.getName()+" Won";
            }

        }

    }

}
