package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1194 {
    private int n, m;
    private char[][] map;
    private Map<Character, Integer> door = new HashMap<>();
    private Queue<Point> dq = new LinkedList<>();
    private boolean[][][] check;
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    private int answer = -1;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int cnt = 1 << 6;

        map = new char[n][m];
        check = new boolean[n][m][cnt];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '0') {
                    dq.offer(new Point(i, j, 0, 1));
                }
            }
        }

        process();

        System.out.println(answer);
    }

    private void process() {
        init();


    }

    private void bfs() {
        while (!dq.isEmpty()) {
            Point p = dq.poll();

            if(map[p.row][p.col] == '1') {
                answer = p.cnt;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int xx = dx[i] + p.row;
                int yy = dy[i] + p.col;

                if(xx < 0 || xx >= n || yy < 0 || yy >= m)
                    continue;
                if(map[xx][yy] == '#' || check[xx][yy][p.key])
                    continue;
                if (65 <= map[xx][yy] && map[xx][yy] <= 70) {

                } else if (97 <= map[xx][yy] && map[xx][yy] <= 102) {

                } else {

                }
            }
        }
    }

    private void init() {
//        door.put('A', 'a');
//        door.put('B', 'b');
//        door.put('C', 'c');
//        door.put('D', 'd');
//        door.put('E', 'e');
//        door.put('F', 'f');
    }

    private class Point {
        int row;
        int col;
        int key;
        int cnt;

        public Point(int row, int col, int key, int cnt) {
            this.row = row;
            this.col = col;
            this.key = key;
            this.cnt = cnt;
        }
    }
}
