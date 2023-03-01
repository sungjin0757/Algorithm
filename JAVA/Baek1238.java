package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1238 {
    private int n, m, x;
    private List<int[]>[] graph;
    private int answer = 0;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, cost});
        }

        process();

        System.out.println(answer);
    }

    private void process() {
        int[][] distance = new int[n + 1][n + 1];
        Arrays.stream(distance).forEach(d -> Arrays.fill(d, Integer.MAX_VALUE));

        for (int i = 1; i <= n; i++) {
            dijkstra(i, distance[i]);
        }

        for (int i = 1; i <= n; i++) {
            if(i == x) {
                answer = Math.max(answer, 0);
                continue;
            }
            answer = Math.max(answer, distance[i][x] + distance[x][i]);
        }
    }

    private void dijkstra(int node, int[] distance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] toNode : graph[node]) {
            pq.offer(toNode);
        }

        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            int to = point[0];
            int cost = point[1];

            if(distance[to] < cost)
                continue;

            distance[to] = cost;

            for (int[] toNode : graph[to]) {
                int next = toNode[0];
                int nextCost = toNode[1];

                if(distance[next] > (nextCost + cost)) {
                    pq.offer(new int[] {next, nextCost + cost});
                }
            }
        }
    }
}
