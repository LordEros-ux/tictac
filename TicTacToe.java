import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize board
        initializeBoard(board);

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

        // Convert slot
        int row = getRow(slot);
        int col = getCol(slot);

        // Validate move
        boolean validMove = isValidMove(board, row, col);

        if (validMove) {

            // UC6 Place move
            placeMove(board, row, col, humanSymbol);

            System.out.println("\nUpdated Board:");
            printBoard(board);

        } else {

            System.out.println("Invalid Move");
        }
    }

    // Initialize board
    public static void initializeBoard(char[][] board) {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
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

    // Get user slot
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

    // Validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        return board[row][col] == '-';
    }

    // UC6 Place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {

        board[row][col] = symbol;
    }
}5