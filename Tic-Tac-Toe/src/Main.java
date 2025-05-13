import com.tictactoe.model.*;
import com.tictactoe.model.piece.Cross;
import com.tictactoe.model.piece.Nought;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Game game = new Game();

        System.out.println("Welcome to TicTacToe Game!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player1's name: ");
        String p1 = scanner.nextLine();

        System.out.println("Hey "+p1+", select your piece. ( O / X ) ");
        String piece = scanner.next();

        while(!piece.equalsIgnoreCase("X") && !piece.equalsIgnoreCase("O")) {
            System.out.println("Select a valid piece: ( O / X) ");
            piece = scanner.nextLine();
        }

        System.out.println("Enter player2's name: ");
        scanner.nextLine();
        String p2 = scanner.nextLine();

        Player player1 = new Player(p1);
        Player player2 = new Player(p2);

        if(piece.equalsIgnoreCase("O")) {
            player1.setPlayingPiece(new Nought());
            player2.setPlayingPiece(new Cross());
        }else{
            player1.setPlayingPiece(new Cross());
            player2.setPlayingPiece(new Nought());
        }


        game.addPlayer(player1);
        game.addPlayer(player2);


        String option = "Y";

        while(option.equalsIgnoreCase("Y")){
            System.out.println(game.startGame());
            System.out.println("Do you want to play again? (Y/N)");
            option = scanner.next();
        }


    }
}