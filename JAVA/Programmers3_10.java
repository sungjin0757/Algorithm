package programmers;
import java.util.*;
public class Programmers3_10 {


    class Solution {
        private int[][] dp;
        private List<Point>[] graph;
        private int[] summits;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = {};
            init(n, gates, paths, summits);
            process(gates);
            return answer;
        }

        private void init(int n, int[] gates, int[][] paths, int[] summits) {
            dp = new int[gates.length][n + 1];
            graph = new ArrayList[n + 1];
            this.summits = summits;
            for(int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < paths.length; i++) {
                int from = paths[i][0];
                int to = paths[i][1];
                int val = paths[i][2];
                Point point1 = new Point(from, val);
                Point point2 = new Point(to, val);
                graph[from].add(point2);
                graph[to].add(point1);
            }

            Arrays.stream(dp).forEach(d -> Arrays.fill(d, Integer.MAX_VALUE));
        }

        private void process(int[] gates) {
            for(int i = 0 ; i < gates.length; i++) {
                dijkstra(gates, gates[i], i);
            }
        }

        private void dijkstra(int[] gates, int gate, int idx) {
            PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {

                @Override
                public int compare(Point o1, Point o2) {
                    return Integer.compare(o1.cost, o2.cost);
                }
            });
            int[] distance = dp[idx];
            distance[gate] = 0;
            for(Point p : graph[gate]) {
                pq.offer(p);
            }

            while(!pq.isEmpty()) {
                Point p = pq.poll();
                int now = p.to;
                int cost = p.cost;
                if(distance[now] < cost) {
                    continue;
                }
                if(Arrays.stream(summits).anyMatch(s -> s == now))
                    continue;
                distance[now] = cost;
                for(Point temp : graph[now]) {
                    if(isGate(gates, temp.to))
                        continue;
                    int dis = temp.cost;
                    pq.offer(new Point(temp.to, dis));
                }
            }
        }

        private boolean isGate(int[] gates, int val) {
            return Arrays.stream(gates).anyMatch(g -> g == val);
        }

        private class Point {
            int to;
            int cost;

            public Point(int to, int cost) {
                this.to = to;
                this.cost = cost;
            }
        }
    }
}
