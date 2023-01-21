import java.util.Scanner;

public class TicTacToe {

  static char[][] board = new char[3][3];
  static Scanner sc = new Scanner(System.in);
  static char player = 'X';

  public static void main(String[] args) {
    initBoard();
    while (true) {
      printBoard();
      getPlayerMove();
      if (isWin()) {
        System.out.println(player + " wins!");
        break;
      }
      if (isDraw()) {
        System.out.println("It's a draw!");
        break;
      }
      switchPlayer();
    }
  }

  public static void initBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = ' ';
      }
    }
  }

  public static void printBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
    }
  }

  public static void getPlayerMove() {
    System.out.println("Player " + player + ", enter row (1-3): ");
    int row = sc.nextInt() - 1;
    System.out.println("Player " + player + ", enter column (1-3): ");
    int col = sc.nextInt() - 1;
    if (board[row][col] != ' ') {
      System.out.println("Invalid move, try again.");
      getPlayerMove();
    } else {
      board[row][col] = player;
    }
  }

  public static void switchPlayer() {
    if (player == 'X') {
      player = 'O';
    } else {
      player = 'X';
    }
  }

  public static boolean isWin() {
    // Check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
        return true;
      }
    }
    // Check columns
    for (int i = 0; i < 3; i++) {
      if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
        return true;
      }
    }
    // Check diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    return false;
  }

  public static boolean isDraw() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == ' ') {
          return false;
        }
      }
    }
    return true;
  }
}
