package programmers;
import java.util.*;

public class Programmers3_3 {
    class Solution {
        private int[] answer;
        private int[] sources;
        private int destination, n;
        private List<Point>[] graph;
        private int[] costs;

        public int[] solution(int n, int[][] roads, int[] sources, int destination)     {
            init(n, roads, sources, destination);
            dijkstra();
            getAnswer();
            return answer;
        }

        private void init(int n, int[][] roads, int[] sources, int destination) {
            costs = new int[n + 1];
            Arrays.fill(costs, 10000000);
            answer = new int[sources.length];
            this.sources = sources;
            this.destination = destination;
            this.n = n;
            costs[destination] = 0;


            graph = new ArrayList[n + 1];
            for(int i =0; i <=n; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i = 0; i < roads.length; i++) {
                int from = roads[i][0];
                int to = roads[i][1];

                graph[from].add(new Point(to, 1));
                graph[to].add(new Point(from, 1));
            }
        }

        private void dijkstra() {
            PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return Integer.compare(o1.cost, o2.cost);
                }
            });
            for(Point p : graph[destination]) {
                pq.offer(p);
            }

            while(!pq.isEmpty()) {
                Point dest = pq.poll();
                int destRoad = dest.road;
                int destCost = dest.cost;
                if(costs[destRoad] < destCost) {
                    continue;
                }
                costs[destRoad] = destCost;
                for(Point p : graph[destRoad]) {
                    int tempCost = p.cost + destCost;
                    if(tempCost < costs[p.road]) {
                        costs[p.road] = tempCost;
                        pq.offer(new Point(p.road, tempCost));
                    }
                }
            }
        }

        private void getAnswer() {
            for(int i =0; i < answer.length; i++) {
                answer[i] = costs[sources[i]];
                if(answer[i] == 10000000) {
                    answer[i] = -1;
                }
            }
        }

        private class Point {
            int road;
            int cost;
            public Point(int road, int cost) {
                this.road = road;
                this.cost = cost;
            }
        }
    }
}
