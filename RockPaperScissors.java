import java.util.Random;
import java.util.Scanner;

/**
 * Plays Rock, Paper, Scissors, keep the kids busy on those long drives.
 */
public class RockPaperScissors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type rock, paper or scissors");
        String move = sc.nextLine();
        System.out.println(playGame(move));
    }

    private static int precedence(String move){
        move = move.toLowerCase();

        if(move.equals("rock")){
            return 0;
        }else if(move.equals("paper")){
            return 1;
        }else if(move.equals("scissors")){
            return 2;
        }
        return -1;
    }

    private static int computer(){
        Random rn  = new Random();
        return rn.nextInt(3);
    }

    private static String compare(int player, int computer){
        if(player == computer){
            return "draw";
        }else if(player == (computer % 3)+1){
              return "player wins";
        }
        return "computer wins";
    }

    private static void talk(int playerMove, int computerMove){
        String message = "Player picked: ";
        switch(playerMove){
            case 0: message += "rock. ";
                break;
            case 1: message += "paper. ";
                break;
            case 2: message += "scissors. ";
                break;
        }
        message += "Computer picked: ";

        switch(computerMove){
            case 0: message += "rock";
                break;
            case 1: message += "paper";
                break;
            case 2: message += "scissors";
                break;
        }
        System.out.println(message);
    }

    public static String playGame(String input){
        int playVal = precedence(input);
        int compVal = computer();

        if(playVal == -1){
            return "invalid input";
        }
        talk(playVal, compVal);
        return compare(playVal, compVal);
    }
}
