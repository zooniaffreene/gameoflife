import java.util.Arrays;

public class GameOfLife implements Board {

    private int[][] board;
    private int rows;
    private int cols;

    public GameOfLife(int x, int y) {
        this.rows = x;
        this.cols = y;
        this.board = new int[rows][cols];
    }

    public void run(int turns) {
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    public void step() {
        print();
        int[][] newBoard = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countNeighbors(i, j);
                if (board[i][j] == 1) {
                    newBoard[i][j] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    newBoard[i][j] = (neighbors == 3) ? 1 : 0;
                }
            }
        }
        
        board = newBoard;
    }


    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit = board[0].length;
        return board[(x + xLimit) % xLimit][(y + yLimit) % yLimit];
    }

    public int[][] get() {
        return board;
    }

   
    public void print() {
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x % 10);
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 1) {
                    System.out.print("⬛");
                } else {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
