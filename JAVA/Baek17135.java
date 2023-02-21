package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17135 {
    private int n, m, d;
    private int[] comb = new int[3];
    private int answer = 0;
    private List<Enemy> list = new ArrayList<>();
    private List<Enemy> copyList;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    list.add(new Enemy(i, j));
                }
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private void dfs(int x, int y) {
        if (x == 3) {
            copy();
            answer = Math.max(answer, attack());
            return;
        }
        for (int i = y; i < m; i++) {
            comb[x] = i;
            dfs(x + 1, i + 1);
        }
    }

    private void copy() {
        copyList = new ArrayList<>();
        for (Enemy e : list) {
            copyList.add(new Enemy(e.row, e.col));
        }
        Collections.sort(copyList, Comparator.comparingInt(c -> -c.col));
    }

    private int attack() {
        int cnt = 0 ;
        for (int i = 0; i < n; i++) {
            Set<Enemy> set = new HashSet<>();
            addEnemy(set);
            cnt += set.size();
            delete(set);
            moveEnemy();
        }
        return cnt;
    }

    private void addEnemy(Set<Enemy> set) {
        for (int i : comb) {
            Enemy enemy = findEnemy(i);
            if(enemy.row == -1)
                continue;
            set.add(enemy);
        }
    }

    private Enemy findEnemy(int col) {
        Enemy enemy = new Enemy(-1, -1);
        int presentDistance = Integer.MAX_VALUE;
        for (Enemy e : copyList) {
            if(e.row >= n)
                continue;
            int distance = Math.abs(n - e.row) + Math.abs(col - e.col);
            if(presentDistance < distance || distance > d)
                continue;
            enemy = e;
            presentDistance = distance;
        }
        return enemy;
    }

    private void delete(Set<Enemy> set) {
        for (Enemy e : set) {
            copyList.remove(e);
        }
    }

    private void moveEnemy() {
        for (Enemy e : copyList) {
            e.row++;
        }
    }

    private class Enemy {
        int row;
        int col;

        public Enemy(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
