package baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek10026 {
    private int n;
    private char[][] arr;
    private boolean[][] check;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    int cnt1 = 0;
    int cnt2 = 0;

    public void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        arr = new char[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();

            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        process();
        check = new boolean[n][n];
        process2();

        System.out.println(cnt1 + " " + cnt2);
    }

    private void process() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(check[i][j])
                    continue;
                bfs(i, j);
                cnt1++;
            }
        }
    }

    private void process2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'R')
                    arr[i][j] = 'G';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(check[i][j])
                    continue;
                bfs(i, j);
                cnt2++;
            }
        }
    }

    private void bfs(int row, int col) {
        char flag = arr[row][col];
        check[row][col] = true;
        Queue<int[]> dq = new LinkedList<>();

        dq.offer(new int[]{row, col});

        while (!dq.isEmpty()) {
            int[] point = dq.poll();

            for (int i = 0; i < 4; i++) {
                int xx = point[0] + dx[i];
                int yy = point[1] + dy[i];

                if(xx < 0 || xx >= n || yy < 0 || yy >= n)
                    continue;
                if(check[xx][yy] || arr[xx][yy] != flag)
                    continue;

                check[xx][yy] = true;
                dq.offer(new int[]{xx, yy});
            }
        }

    }
}
