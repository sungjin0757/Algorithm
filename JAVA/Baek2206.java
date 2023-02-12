package baekjoon;

import java.io.IOException;
import java.util.*;

public class Baek2206 {
    private int n, m;
    private int[][] map;
    private int[] dx = new int[] { -1, 1, 0, 0};
    private int[] dy = new int[] { 0, 0, -1, 1};
    private boolean[][][] check;
    private int answer = -1;

    public void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String[] temp = scanner.nextLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        process();

        System.out.println(answer);
    }

    private void process() {
        Queue<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{0, 0, 0, 1});

        while (!dq.isEmpty()) {
            int[] point = dq.poll();

            if (point[0] == n - 1 && point[1] == m - 1) {
                answer = point[3];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int xx = point[0] + dx[i];
                int yy = point[1] + dy[i];

                if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                    continue;
                }
                if(check[xx][yy][point[2]])
                    continue;
                if (map[xx][yy] == 0) {
                    check[xx][yy][point[2]] = true;
                    dq.offer(new int[] {xx, yy, point[2], point[3] + 1});
                } else if (point[2] == 0) {
                    check[xx][yy][1] = true;
                    dq.offer(new int[] {xx, yy, 1, point[3] + 1});
                }
            }
        }
    }

}
