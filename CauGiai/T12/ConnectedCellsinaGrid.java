import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Cell {
    public int r, c;

    public Cell(int i, int j) {
        r = i;
        c = j;
    }
}

public class Solution {

    static int[][] grid;
    static boolean[][] visited;
    static int N, M;

    static int[] moveRow = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] moveCol = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static boolean validPos(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static int count_connected(int row, int col) {
        int cnt = 1;
        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            int curRow = row + moveRow[i];
            int curCol = col + moveCol[i];

            if (validPos(curRow, curCol) && !visited[curRow][curCol] && grid[curRow][curCol] == 1) {
                cnt += count_connected(curRow, curCol);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}