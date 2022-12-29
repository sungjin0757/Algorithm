package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek19238_2 {
    private int n, m, k;
    private int[][] map;
    private boolean[][] checkMap;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private Taxi taxi;
    List<Person> persons = new ArrayList<>();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        checkMap = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    checkMap[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        taxi = new Taxi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), k);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dr = Integer.parseInt(st.nextToken());
            int dc = Integer.parseInt(st.nextToken());
            persons.add(new Person(r, c, dr, dc));
        }
        System.out.println(process());
    }

    private int process() {
        for(int i = 0; i < m; i++) {
            Person person = getPerson();
            goPerson(person);
            if(taxi.fuel < 0)
                return -1;
            removePersonInList(person);
        }
        return taxi.fuel;
    }

    private void goPerson(Person person) {
        int needFuel = (person.distanceWithTaxi + person.needFuel);
        taxi.fuel -= needFuel;
        taxi.row = person.destRow;
        taxi.col = person.destCol;
    }

    private void removePersonInList(Person person) {
        persons.remove(person);
    }

    private Person getPerson() {
        PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.distanceWithTaxi == o2.distanceWithTaxi) {
                if(o1.row == o2.row)
                    return Integer.compare(o1.col, o2.col);
                return Integer.compare(o1.row, o2.row);
            }
            return Integer.compare(o1.distanceWithTaxi, o2.distanceWithTaxi);
        });
        for (Person person : persons) {
            person.updateDistanceWithTaxi();
            pq.offer(person);
        }
        return pq.peek();
    }

    private int getDistance(int row, int col, int destRow, int destCol, int cnt) {
        if (row == destRow && col == destCol) {
            return cnt;
        }
        if (map[row][col] == Integer.MAX_VALUE)
            return map[row][col];
        for(int i = 0; i < 4; i++) {
            int xx = row + dx[i];
            int yy = col + dy[i];
            if (xx <= 0 || xx > n || yy <= 0 || yy > n) {
                continue;
            }
            if(checkMap[xx][yy])
                continue;
            checkMap[xx][yy] = true;
            map[row][col] = Math.max(getDistance(xx, yy, destRow, destCol, cnt +1), map[row][col]);
            checkMap[xx][yy] = false;
        }
        return map[row][col];
    }

    private void mapInit() {
        Arrays.stream(map).forEach(m -> Arrays.fill(m, Integer.MAX_VALUE));
    }

    private class Taxi {
        int row;
        int col;
        int fuel;

        public Taxi(int row, int col, int fuel) {
            this.row = row;
            this.col = col;
            this.fuel = fuel;
        }
    }

    private class Person {
        int row;
        int col;
        int destRow;
        int destCol;
        int needFuel;
        int distanceWithTaxi;

        public Person(int row, int col, int destRow, int destCol) {
            this.row = row;
            this.col = col;
            this.destRow = destRow;
            this.destCol = destCol;
            setNeedFuel();
        }

        private void setNeedFuel() {
            mapInit();
            needFuel = getDistance(row, col, destRow, destCol, 0);
        }

        public void updateDistanceWithTaxi() {
            mapInit();
            distanceWithTaxi = getDistance(row, col, taxi.row, taxi.col, 0);
        }
    }

}
