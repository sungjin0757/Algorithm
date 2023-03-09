package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9663 {
    private int n;
    private int answer = 0;
    private int[] board = new int[15];

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(answer);
    }

    private void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;
            if(isPossible(row)) {
                dfs(row + 1);
            }
        }
    }

    private boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            int prevCol = board[i];
            int rowDiff = Math.abs(row - i);
            int colDiff = Math.abs(board[i] - board[row]);
            if((prevCol == board[row]) || (rowDiff == colDiff))
                return false;
        }
        return true;
    }
}
