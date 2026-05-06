import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize board
        initializeBoard(board);

        System.out.println("Initial Board:");
        printBoard(board);

        Random random = new Random();

        // Toss logic
        int toss = random.nextInt(2);

        char humanSymbol;
        char computerSymbol;

        if (toss == 0) {

            humanSymbol = 'X';
            computerSymbol = 'O';

            System.out.println("\nHuman plays first.");

        } else {

            humanSymbol = 'O';
            computerSymbol = 'X';

            System.out.println("\nComputer plays first.");
        }

        System.out.println("Human Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);

        // Human move
        int slot = getUserSlot();

        int row = getRow(slot);
        int col = getCol(slot);

        if (isValidMove(board, row, col)) {

            placeMove(board, row, col, humanSymbol);

            System.out.println("\nBoard After Human Move:");
            printBoard(board);

        } else {

            System.out.println("Invalid Human Move");
        }

        // UC7 Computer move
        computerMove(board, computerSymbol);

        System.out.println("\nBoard After Computer Move:");
        printBoard(board);
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

    // Convert slot to col
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

    // Place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    // UC7 Computer random move
    public static void computerMove(char[][] board, char computerSymbol) {

        Random random = new Random();

        int slot;
        int row;
        int col;

        do {

            slot = random.nextInt(9) + 1;

            row = getRow(slot);
            col = getCol(slot);

        } while (!isValidMove(board, row, col));

        placeMove(board, row, col, computerSymbol);

        System.out.println("\nComputer selected slot: " + slot);
    }
}