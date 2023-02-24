package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2638 {
    private int n, m;
    private int[][] arr;
    private boolean[][] check;
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    private List<int[]> list = new ArrayList<>();
    private int answer = 0;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        process();

        System.out.println(answer);
    }

    private void process() {
        while (!list.isEmpty()) {
            List<int[]> temp = new ArrayList<>();
            check = new boolean[n][m];
            dfs(0, 0);

            for(int[] i : list) {
                if(isOuter(i[0], i[1])) {
                    temp.add(i);
                }
            }

            for (int[] i : temp) {
                arr[i[0]][i[1]] = 0;
                list.remove(i);
            }
            answer++;
        }
    }

    private void dfs(int x, int y) {
        check[x][y] = true;
        arr[x][y] = 2;

        for(int i = 0 ; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx < 0 || xx >= n || yy < 0 || yy >= m)
                continue;
            if(check[xx][yy] || arr[xx][yy] == 1)
                continue;
            dfs(xx, yy);
        }
    }

    private boolean isOuter(int row, int col) {
        int cnt = 0;
        for(int i = 0 ; i < 4; i++) {
            int xx = row + dx[i];
            int yy = col + dy[i];

            if(arr[xx][yy] == 2)
                cnt++;
        }
        return cnt >= 2;
    }
}
