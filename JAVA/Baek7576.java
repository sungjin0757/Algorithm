package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek7576 {
    private int m, n;
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    private int[][] arr;
    private boolean[][] check;
    private int answer = -1;
    private Queue<Point> dq = new LinkedList<>();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    dq.offer(new Point(i, j, 0));
                }
            }
        }

        process();

        System.out.println(answer);
    }

    private void process() {
        while (!dq.isEmpty()) {
            Point point = dq.poll();
            answer = Math.max(point.day, answer);
            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + point.row;
                int yy = dy[i] + point.col;

                if(!validatePoint(xx, yy))
                    continue;
                if(arr[xx][yy] == -1 || check[xx][yy])
                    continue;
                arr[xx][yy] = 1;
                check[xx][yy] = true;
                dq.offer(new Point(xx, yy, point.day + 1));
            }

        }

        if (!isEnd()) {
            answer = -1;
        }
        if(answer == 1)
            answer = 0;
    }

    private boolean isEnd() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    private boolean validatePoint(int row, int col) {
        return (row < n) && (row >= 0) && (col < m) && (col >=0);
    }

    private class Point {
        int row;
        int col;
        int day;

        public Point(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }
}
