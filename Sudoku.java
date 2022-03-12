import java.util.Arrays;

public class Sudoku {
    public static boolean solve(int[][] board, int row, int col) {
        if (col >= board.length) {
            row++;
            col = 0;
        }
        if (row >= board.length) {
            return true;
        }
        if (board[row][col] != 0) {
            return solve(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (canPlace(board, row, col, i)) {
                board[row][col]=i;
                if(solve(board,row,col+1)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean canPlace(int[][] board, int row, int col, int i) {

        return rowSafe(board, row, col, i) && colSafe(board, row, col, i) && squareSafe(board, row, col, i);
    }

    private static boolean rowSafe(int[][] board, int row, int col, int i) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == i) {
                return false;
            }
        }
        return true;
    }

    private static boolean colSafe(int[][] board, int row, int col, int i) {
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == i) {
                return false;
            }
        }
        return true;
    }

    private static boolean squareSafe(int[][] board, int row, int col, int i) {
        int boxRow = row/3*3;
        int boxCol = col/3*3;

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if(board[boxRow+j][boxCol+k]==i){
                    return false;
                }
            }
        }

        return true;
    }

    public static void printArray(int[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
        board[0][2] = 6;
        board[0][4] = 3;
        board[0][6] = 7;
        board[0][7] = 2;
        board[1][1] = 7;
        board[1][4] = 9;
        board[1][7] = 6;
        board[2][5] = 8;
        board[3][2] = 8;
        board[3][5] = 5;
        board[3][8] = 4;
        board[4][0] = 4;
        board[4][5] = 1;
        board[4][8] = 7;
        board[5][0] = 2;
        board[5][1] = 5;
        board[5][7] = 1;
        board[6][0] = 6;
        board[6][1] = 2;
        board[7][2] = 4;
        board[7][6] = 5;
        board[8][3] = 3;
        board[8][6] = 1;
        board[8][7] = 8;
        solve(board,0,0);
        printArray(board);
    }

}
