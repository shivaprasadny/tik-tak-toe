import java.util.Scanner;

public class TicTacToe {

    // The game board (3x3)
    static char[] board = new char[9];
    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        // Initialize board with 1–9 positions
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i); // '1','2',...,'9'
        }

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player X and Player O take turns.");
        System.out.println("Choose a position from 1 to 9.\n");

        printBoard();

        while (!gameEnded) {

            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");

            int move;

            // Validate input is an integer and within 1-9
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.next(); // clear invalid input
                continue;
            }

            move = scanner.nextInt();

            if (move < 1 || move > 9) {
                System.out.println("Invalid position. Try again (1-9).");
                continue;
            }

            int index = move - 1;

            // Check if position is already taken
            if (board[index] == 'X' || board[index] == 'O') {
                System.out.println("That spot is already taken. Try another one.");
                continue;
            }

            // Place the move
            board[index] = currentPlayer;

            // Print updated board
            printBoard();

            // Check if current player has won
            if (hasWon(currentPlayer)) {
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameEnded = true;
            }
            // Check if it's a draw
            else if (isDraw()) {
                System.out.println("It's a draw! 😅");
                gameEnded = true;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    // Print the current board
    public static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    // Check if a player has won
    public static boolean hasWon(char player) {
        // Rows
        if ((board[0] == player && board[1] == player && board[2] == player) ||
                (board[3] == player && board[4] == player && board[5] == player) ||
                (board[6] == player && board[7] == player && board[8] == player) ||

                // Columns
                (board[0] == player && board[3] == player && board[6] == player) ||
                (board[1] == player && board[4] == player && board[7] == player) ||
                (board[2] == player && board[5] == player && board[8] == player) ||

                // Diagonals
                (board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player)) {
            return true;
        }
        return false;
    }

    // Check if board is full (draw)
    //l
    public static boolean isDraw() {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return false; // still empty spot
            }
        }
        return true;
    }
}
