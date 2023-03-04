package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1939 {
    private int n, m, answerFrom, answerTo;
    private List<int[]>[] graph;
    private int min = 0;
    private int max = 0;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[] {b, c});
            graph[b].add(new int[] {a, c});

            max = Math.max(max, c);
        }

        st = new StringTokenizer(br.readLine(), " ");
        answerFrom = Integer.parseInt(st.nextToken());
        answerTo = Integer.parseInt(st.nextToken());

        process();

        System.out.println(max);
    }

    private void process() {
        while (min <= max) {
            int mid = (min + max) / 2;
            boolean[] visit = new boolean[n + 1];

            if(bfs(answerFrom, answerTo, mid, visit)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
    }

    private boolean bfs(int start, int end, int limit, boolean[] visit) {
        Queue<Integer> dq = new LinkedList<>();

        dq.offer(start);
        visit[start] = true;

        while (!dq.isEmpty()) {
            int to = dq.poll();

            if(to == end)
                return true;

            for (int[] g : graph[to]) {
                if(visit[g[0]])
                    continue;
                if(g[1] < limit)
                    continue;
                visit[g[0]] = true;
                dq.offer(g[0]);
            }
        }

        return false;
    }
}
