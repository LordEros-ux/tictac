import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        initializeBoard(board);

        char humanSymbol = 'X';
        char computerSymbol = 'O';

        boolean humanTurn = true;
        boolean gameRunning = true;

        System.out.println("TIC TAC TOE");

        while (gameRunning) {

            printBoard(board);

            if (humanTurn) {

                System.out.println("\nHuman Turn");

                int slot = getUserSlot();

                int row = getRow(slot);
                int col = getCol(slot);

                if (isValidMove(board, row, col)) {

                    placeMove(board, row, col, humanSymbol);

                    // UC9 Winner Check
                    if (checkWinner(board, humanSymbol)) {

                        printBoard(board);

                        System.out.println("\nHuman Wins!");

                        gameRunning = false;

                    } else if (isBoardFull(board)) {

                        printBoard(board);

                        System.out.println("\nMatch Draw!");

                        gameRunning = false;

                    } else {

                        humanTurn = false;
                    }

                } else {

                    System.out.println("Invalid Move");
                }

            } else {

                System.out.println("\nComputer Turn");

                computerMove(board, computerSymbol);

                // UC9 Winner Check
                if (checkWinner(board, computerSymbol)) {

                    printBoard(board);

                    System.out.println("\nComputer Wins!");

                    gameRunning = false;

                } else if (isBoardFull(board)) {

                    printBoard(board);

                    System.out.println("\nMatch Draw!");

                    gameRunning = false;

                } else {

                    humanTurn = true;
                }
            }
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

        System.out.println();

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                System.out.print(board[row][col] + " ");
            }

            System.out.println();
        }
    }

    // Get user slot
    public static int getUserSlot() {

        System.out.print("\nEnter slot (1-9): ");

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

    // Place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    // Computer move
    public static void computerMove(char[][] board, char computerSymbol) {

        int slot;
        int row;
        int col;

        do {

            slot = random.nextInt(9) + 1;

            row = getRow(slot);
            col = getCol(slot);

        } while (!isValidMove(board, row, col));

        placeMove(board, row, col, computerSymbol);

        System.out.println("Computer selected slot: " + slot);
    }

    // UC9 Winner check
    public static boolean checkWinner(char[][] board, char symbol) {

        // Check rows
        for (int row = 0; row < 3; row++) {

            if (board[row][0] == symbol &&
                board[row][1] == symbol &&
                board[row][2] == symbol) {

                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {

            if (board[0][col] == symbol &&
                board[1][col] == symbol &&
                board[2][col] == symbol) {

                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {

            return true;
        }

        // Check opposite diagonal
        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {

            return true;
        }

        return false;
    }

    // Check draw
    public static boolean isBoardFull(char[][] board) {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == '-') {

                    return false;
                }
            }
        }

        return true;
    }
}