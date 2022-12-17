package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek14499_2 {
    private int n, m, x, y, k;
    private int[] command, dice, present;
    private int[] dx = new int[]{0, 0, -1, 1};
    private int[] dy = new int[]{1, -1, 0, 0};
    private int[][] map;
    private List<Integer> res = new ArrayList<>();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        command = new int[k];
        dice = new int[6];
        present = new int[2];

        present[0] = x;
        present[1] = y;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");

        for(int i =0; i < k; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }
        process();
        printRes();
    }

    private void process() {
        for(int i = 0 ;i < k; i++) {
            boolean check = move(command[i]);
            if(!check)
                continue;
            copyMapInDice();
            res.add(dice[0]);
        }
    }

    private boolean move(int dir) {
        if(!verifyMap(dir))
            return false;
        if(dir == 1) {
            moveEast();
        } else if(dir == 2) {
            moveWest();
        } else if(dir == 3) {
            moveNorth();
        } else if(dir == 4) {
            moveSouth();
        }
        return true;
    }

    private boolean verifyMap(int dir) {
        int xx = present[0] + dx[dir - 1];
        int yy = present[1] + dy[dir - 1];
        if(xx < 0 || xx >= n || yy < 0 || yy >= m)
            return false;

        present[0] = xx;
        present[1] = yy;
        return true;
    }

    private void moveEast() {
        swap(0, 2, 5, 4);
    }

    private void moveWest() {
        swap(0, 4, 5, 2);
    }

    private void moveNorth() {
        swap(0, 3, 5, 1);
    }

    private void moveSouth() {
        swap(0, 1, 5, 3);
    }

    private void swap(int dir1, int dir2, int dir3, int dir4) {
        int temp = dice[dir2];
        dice[dir2] = dice[dir1];

        int temp2 = dice[dir3];
        dice[dir3] = temp;

        int temp3 = dice[dir4];
        dice[dir4] =temp2;

        dice[dir1] = temp3;
    }

    private void copyMapInDice() {
        int xx = present[0];
        int yy = present[1];
        if(map[xx][yy] == 0) {
            map[xx][yy] = dice[5];
        } else if(map[xx][yy] != 0) {
            dice[5] = map[xx][yy];
            map[xx][yy] = 0;
        }
    }

    private void printRes() {
        res.stream().forEach(System.out::println);
    }
}
