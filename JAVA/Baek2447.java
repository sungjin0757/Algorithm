package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2447 {
    private int n;
    private char[][] arr;
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        printStar(0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private void printStar(int row, int col, int n, boolean blank) {
        if(blank) {
            for (int i = row; i < row + n; i++) {
                for (int j = col; j < col + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1) {
            arr[row][col] = '*';
            return;
        }

        int size = n / 3;
        for(int i = row; i < row + n; i += size) {
            for (int j = col; j < col + n; j += size) {
                if (i == size + row && j == size + col) {
                    printStar(i, j, size, true);
                }else {
                    printStar(i, j, size, false);
                }
            }
        }

    }
}
