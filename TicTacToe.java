import java.util.Random;
import java.util.Scanner;

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

        // Toss logic
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

        // UC3 + UC4
        int slot = getUserSlot();

        int row = getRow(slot);
        int col = getCol(slot);

        System.out.println("\nSelected Slot: " + slot);
        System.out.println("Row Index: " + row);
        System.out.println("Column Index: " + col);
    }

    // UC3
    public static int getUserSlot() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter slot number (1-9): ");

        return scanner.nextInt();
    }

    // UC4
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // UC4
    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }
}