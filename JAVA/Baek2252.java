package baekjoon;


import java.util.*;

public class Baek2252 {
    private int n, m;
    private List<Integer>[] graph;
    private int[] degree;
    private StringBuilder sb = new StringBuilder();

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        degree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(scanner.nextLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            degree[b]++;
        }

        process();

        System.out.println(sb.toString());

    }

    private void process() {
        Queue<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(degree[i] == 0)
                dq.offer(i);
        }

        while (!dq.isEmpty()) {
            int idx = dq.poll();
            sb.append(idx + " ");

            for (int row : graph[idx]) {
                degree[row]--;
                if(degree[row] == 0)
                    dq.offer(row);
            }
        }

        sb.deleteCharAt(sb.length() - 1);
    }
}
