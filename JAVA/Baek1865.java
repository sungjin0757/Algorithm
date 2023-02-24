package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1865 {
    private int tc;
    private StringBuilder sb = new StringBuilder();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<int[]>[] graph = new ArrayList[n + 1];

            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s].add(new int[] {e, t});
                graph[e].add(new int[] {s, t});
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s].add(new int[] {e, -t});
            }

            process(graph, n);
        }

        System.out.print(sb.toString());
    }

    private void process(List<int[]>[] graph, int n) {
        if (isBellman(graph, n)) {
            sb.append("YES\n");
        } else {
            sb.append("NO\n");
        }
    }

    private boolean isBellman(List<int[]>[] graph, int n) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, 1000000000);
        dis[1] = 0;

        boolean update = false;

        for(int i = 1; i < n; i++) {
            update = false;
            for (int j = 1; j <= n; j++) {
                for(int[] k : graph[j]) {
                    if (dis[k[0]] > dis[j] + k[1]) {
                        dis[k[0]] = dis[j] + k[1];
                        update = true;
                    }
                }
            }
            if(!update)
                break;
        }

        if (update) {
            for (int i = 1; i <= n; i++) {
                for (int[] j : graph[i]) {
                    if (dis[j[0]] > dis[i] + j[1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
