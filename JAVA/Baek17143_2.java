package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek17143_2 {
    private int r, c, m;
    private int[][] map;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private PriorityQueue<Shark>[][] pq;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[r + 1][c + 1];
        pq = new PriorityQueue[r + 1][c + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sharkR = Integer.parseInt(st.nextToken());
            int sharkC = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            pq[sharkR][sharkC] = new PriorityQueue<>(Comparator.comparingInt(o -> o.size));
            pq[sharkR][sharkC].offer(new Shark(s, d, z));
        }
    }

    private void processShark() {
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= r; j++) {
                if(!verifyQueue(i, j))
                    continue;
                Shark shark = pq[i][j].poll();
                moveShark(shark, i, j);
                processEat();
            }
        }
    }

    private void moveShark(Shark shark, int x, int y) {
        int xx = (dx[shark.direction] * shark.velocity) + x;
        int yy = (dy[shark.direction] * shark.velocity) + y;
        if(!verifySharkLocation(xx, yy)) {

        }
        if(pq[xx][yy] == null)
            pq[xx][yy] = new PriorityQueue<>(Comparator.comparingInt(o -> o.size));
        pq[xx][yy].offer(shark);
    }

    private boolean verifySharkLocation(int x, int y) {
        if(x <=0 || x > r || y <= 0 || y > c)
            return false;
        return true;
    }

    private void processEat() {
        for(int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(!verifyQueue(i, j))
                    continue;
                if(pq[i][j].size() == 1)
                    continue;
                eatShark(i, j);
            }
        }
    }

    private boolean verifyQueue(int x, int y) {
        if(pq[x][y] == null | pq[x][y].isEmpty())
            return false;
        return true;
    }

    private void eatShark(int x, int y) {

    }

    class Shark {
        int velocity;
        int direction;
        int size;

        public Shark(int velocity, int direction, int size) {
            this.velocity = velocity;
            this.direction = direction;
            this.size = size;
        }
    }
}
