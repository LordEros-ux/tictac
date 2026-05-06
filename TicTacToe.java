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

        printBoard(board);

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

        // Get slot
        int slot = getUserSlot();

        // Convert slot to indices
        int row = getRow(slot);
        int col = getCol(slot);

        System.out.println("\nRow Index: " + row);
        System.out.println("Column Index: " + col);

        // Validate move
        boolean validMove = isValidMove(board, row, col);

        if (validMove) {
            System.out.println("Valid Move");
        } else {
            System.out.println("Invalid Move");
        }
    }

    // Print board
    public static void printBoard(char[][] board) {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }

            System.out.println();
        }
    }

    // User input
    public static int getUserSlot() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter slot number (1-9): ");

        return scanner.nextInt();
    }

    // Convert slot to row
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // Convert slot to column
    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // UC5 Validation
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Boundary check
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Cell empty check
        return board[row][col] == '-';
    }
}