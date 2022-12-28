package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek19236_2 {
    private int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    private int[] dy = new int[] {0, -1, -1, -1, 0, 1, 1, 1};
    private PriorityQueue<Fish> fishQueue = new PriorityQueue<>(Comparator.comparingInt(Fish::getFishNum));
    private Shark shark = new Shark(0,0);
    private Queue<Fish>[][] fishMap = new Queue[4][4];

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Fish fish = new Fish(i, j, b - 1, a);
                fishQueue.offer(fish);
                fishMap[i][j] = new LinkedList<>();
                fishMap[i][j].add(fish);
            }
        }
        shark.dir = fishMap[0][0].peek().dir;
    }

    private void fishMove(Queue<Fish>[][] fishMap) {
        addPriorityQueue(fishMap);
        while (!fishQueue.isEmpty()) {
            Fish fish = fishQueue.poll();
            fish.move();
        }
    }

    private void addPriorityQueue(Queue<Fish>[][] fishMap) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(fishMap[i][j].isEmpty())
                    continue;
                fishQueue.add(fishMap[i][j].peek());
            }
        }
    }

    private class Shark {
        private int row;
        private int col;
        private int dir;

        public Shark(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private class Fish {
        private int row;
        private int col;
        private int dir;
        private int fishNum;

        public Fish(int row, int col, int dir, int fishNum) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.fishNum = fishNum;
        }

        public int getFishNum() {
            return fishNum;
        }

        public void move() {
            int findDir = findDirection(dir, 0);
            if(findDir == -1)
                return;
            int xx = row + dx[findDir];
            int yy = col + dy[findDir];
            swap(xx, yy);
        }

        private int findDirection(int tempDir, int cnt) {
            if (cnt >= 8) {
                return -1;
            }
            int xx = row + dx[tempDir];
            int yy = col + dy[tempDir];
            int res = tempDir;
            if (!validateIfMMove(xx, yy)) {
                res = findDirection((tempDir + 1) % 8, cnt + 1);
            }

            return res;
        }

        private boolean validateIfMMove(int row, int col) {
            if(shark.row == row && shark.col == col)
                return false;
            if(row > 3 || row < 0 || col > 3 || col < 0)
                return false;
            return true;
        }

        private void swap(int changeRow, int changeCol) {
            if (!fishMap[changeRow][changeCol].isEmpty()) {
                Fish fish = fishMap[changeRow][changeCol].poll();
                fish.row = this.row;
                fish.col = this.col;
                fishMap[this.row][this.col].offer(fish);
            }
            Fish thisFish = fishMap[this.row][this.col].poll();
            fishMap[changeRow][changeCol].offer(thisFish);
            this.row = changeRow;
            this.col = changeCol;
        }
    }
}

