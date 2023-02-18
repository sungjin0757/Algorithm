package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1766 {
    private int n, m;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private StringBuilder sb = new StringBuilder();
    private int[] degree;
    private List<Integer>[] graph;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        degree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            degree[to]++;
        }

        process();

        System.out.println(sb.toString());
    }

    private void process() {
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int point = pq.poll();
            sb.append(point + " ");

            for (int i : graph[point]) {
                degree[i]--;
                if(degree[i] == 0) {
                    pq.offer(i);
                }
            }
        }
    }
}
