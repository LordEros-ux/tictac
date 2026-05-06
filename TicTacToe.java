import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize board
        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }

        // Print board
        System.out.println("Tic-Tac-Toe Board:");

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }

            System.out.println();
        }

        // UC2: Toss Logic
        Random random = new Random();

        int toss = random.nextInt(2);

        char humanSymbol;
        char computerSymbol;
        String currentPlayer;

        if (toss == 0) {

            humanSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "Human";

        } else {

            humanSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }

        System.out.println("\nToss Result:");
        System.out.println("Human Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println(currentPlayer + " will play first.");
    }
}