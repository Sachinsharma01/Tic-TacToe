/* Inorder to successfully execute this file you need to download the Computer_choices.java as well else it will not work*/
// develped by sachin sharma 
// github --> Sachinsharma01

import java.util.Scanner;

// Welcome Greet to the user when the game starts
class Welcome{
    String name;
    public void greeting(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the TicTacToe console based game : \n");
        /* Game Rules */
        System.out.println("Rules of the game\n" +
                "1 - You can choose the position number between 1 - 9\n" +
                "2 - Every time you or the computer won the score will be increased by 100 points\n" +
                "3 - You can input your name only once.\n" +
                "4 - You can choose your character only O or X\n" +
                "5 - You and the Computer have only 3 chances to play the game." +
                "Wish you Best of Luck!!.\n");
        // taking player name
        System.out.print("Enter Your name : ");
        name = sc.nextLine();
    }
}

public class TicTacToeGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Welcome w = new Welcome();
        w.greeting();
        Computer_Choices c = new Computer_Choices();  // object of Computer_choices class to take place  of user

        String[] line1 = {" ", " ", " "};
        String[] line2 = {" ", " ", " "};
        String[] line3 = {" ", " ", " "};
        int UserScore = 0, SystemScore = 0;

        /* User and System Symbol whether X or O */
        System.out.print(w.name + " Enter your Symbol choice X(uppercase) or O(uppercase) : ");
        String user_symbol = sc.next().toUpperCase();
        String system_symbol;
        if (user_symbol.equals("X"))
            system_symbol = "O";
        else
            system_symbol = "X";

        /* Handling Action from the input given by user
           Which Symbol is being placed on which position
         */
        boolean Exit = true;
        int chances = 0;
        while (Exit) {
            int SystemChoice = c.System_choice();
            int UserChoice = c.user_choice();
            System.out.println("Computer = " + SystemChoice);
            System.out.println("User = " + UserChoice);
            if (SystemChoice == UserChoice || SystemChoice == 0)
                SystemChoice = c.System_choice();

            // Events for User
            if (UserChoice <= 3 )
                line1[UserChoice - 1] = user_symbol;
            else if (UserChoice <= 6)
                line2[(UserChoice - 3) - 1] = user_symbol;
            else if (UserChoice <= 9)
                line3[(UserChoice - 6) - 1] = user_symbol;

            // Events for System AI
            if (SystemChoice <= 3)
                line1[SystemChoice - 1] = system_symbol;
            else if (SystemChoice <= 6)
                line2[(SystemChoice - 3) - 1] = system_symbol;
            else if (SystemChoice <= 9)
                line3[(SystemChoice - 6) - 1] = system_symbol;

            System.out.print("_____________\n| ");
            for (String i : line1)
                System.out.print(i + " | ");
            System.out.print("\n_____________");
            System.out.print("\n| ");
            for (String j : line2)
                System.out.print(j + " | ");
            System.out.print("\n_____________");
            System.out.print("\n| ");
            for (String k : line3)
                System.out.print(k + " | ");
            System.out.println("\n_____________");

            boolean UserWon = (line1[0].equals(user_symbol) && line1[1].equals(user_symbol) && line1[2].equals(user_symbol))
                    || (line2[0].equals(user_symbol) && line2[1].equals(user_symbol) && line2[2].equals(user_symbol))
                    || (line3[0].equals(user_symbol) && line3[1].equals(user_symbol) && line3[2].equals(user_symbol));

            boolean SystemWon = (line1[0].equals(system_symbol) && line1[1].equals(system_symbol) && line1[2].equals(system_symbol))
                    || (line2[0].equals(system_symbol) && line2[1].equals(system_symbol) && line2[2].equals(system_symbol))
                    || (line3[0].equals(system_symbol) && line3[1].equals(system_symbol) && line3[2].equals(system_symbol));
            System.out.println(UserWon);
            // Handling Events for Winning and Loosing There are 8 possible ways to Win the game
            if (UserWon){
                System.out.println(w.name + " Won!!!");
                UserScore++;
                System.out.println("Computer Score : " + SystemScore + "\n" + w.name + " Score : " + UserScore);
                System.out.println("You want to continue yes or no : ");
                String carryOn = sc.next().toUpperCase();
                Exit = carryOn.equals("YES");
            }
            else if (SystemWon){
                System.out.println("Computer Won!!");
                SystemScore++;
                System.out.println("Computer Score : " + SystemScore + "\n" + w.name + " Score : " + UserScore);
                String carryOn = sc.next().toUpperCase();
                Exit = carryOn.equals("YES");
            }
            if (chances == 3 && UserScore == 0 && SystemScore == 0){
                System.out.println("Chances are over");
                System.out.println("Computer Score : " + SystemScore + "\n" + w.name + " Score : " + UserScore);
                String carryOn = sc.next().toUpperCase();
                Exit = carryOn.equals("YES");
            }
            chances++;
        }
        sc.close();
    }
}
