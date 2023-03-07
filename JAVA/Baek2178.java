package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2178 {
    private int n, m;
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    private int[][] arr;
    private boolean[][] check;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bfs();

        System.out.println(arr[n - 1][m - 1]);
    }

    private void bfs() {
        Queue<Point> dq = new LinkedList<>();
        dq.offer(new Point(0, 0));

        while (!dq.isEmpty()) {
            Point point = dq.poll();

            for (int i = 0; i < 4; i++) {
                int xx = point.row + dx[i];
                int yy = point.col + dy[i];
                if(xx < 0 || xx >= n || yy < 0 || yy >= m)
                    continue;
                if(check[xx][yy] || arr[xx][yy] == 0)
                    continue;
                check[xx][yy] = true;
                arr[xx][yy] += arr[point.row][point.col];
                dq.offer(new Point(xx, yy));
            }
        }
    }

    private class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
