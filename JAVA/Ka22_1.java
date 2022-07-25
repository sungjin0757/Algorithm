package kakao;

import java.util.Arrays;

public class Ka22_1 {
    private int n, m;
    private int[][] total, board;

    public int solution(int[][] board, int[][] skill) {
        n = board.length;
        m = board[0].length;
        this.board = board;

        total = new int[n + 1][m + 1];
        makeTotal(skill);
        arraySum();

        return res();
    }

    private void makeTotal(int[][] skill) {
        for (int[] s : skill) {
            int t = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int d = s[5];
            checkType(t, r1, c1, r2, c2, d);
        }
        upDownSum();
        leftRightSum();
    }

    private void checkType(int t, int r1, int c1, int r2, int c2, int d) {
        if(t == 1)
            d = -d;
        doType(r1, c1, r2, c2, d);
    }

    private void doType(int r1, int c1, int r2, int c2, int d) {
        total[r1][c1] += d;
        total[r1][c2 + 1] += -d;
        total[r2 + 1][c1] += -d;
        total[r2 + 1][c2 +1 ] += d;
    }

    private void upDownSum() {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                total[i][j] += total[i-1][j];
            }
        }
    }

    private void leftRightSum() {
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                total[j][i] += total[j][i-1];
            }
        }
    }

    private void arraySum() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += total[i][j];
            }
        }
    }

    private int res() {
        int cnt = 0;

        for (int[] bb : board) {
            cnt += Arrays.stream(bb).filter(b -> b > 0).count();
        }
        return cnt;
    }
}
