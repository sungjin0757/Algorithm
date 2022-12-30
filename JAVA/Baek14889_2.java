package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14889_2 {
    private int n;
    private int[][] map;
    private int res = Integer.MAX_VALUE;
    private boolean[] temp;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        temp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1);
        System.out.println(res);
    }

    private void dfs(int x, int y) {
        if (x == n / 2) {
            calRes();
            return;
        }

        for (int i = y; i <= n; i++) {
            temp[i] = true;
            dfs(x + 1, i + 1);
            temp[i] = false;
        }
    }

    private void calRes() {
        int diff = calDiff();
        res = Math.min(diff, res);
    }

    private int calDiff() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j)
                    continue;
                int sum = (map[i][j] + map[j][i]);
                if (temp[i] && temp[j]) {
                    sum1 += sum;
                } else if(!temp[i] && !temp[j]) {
                    sum2 += sum;
                }
            }
        }
        return Math.abs(sum1 - sum2);
    }
}
