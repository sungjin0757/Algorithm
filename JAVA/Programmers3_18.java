package programmers;
import java.util.*;

public class Programmers3_18 {

    class Solution {
        private int[] parent;

        public int solution(int n, int[][] costs) {

            return process(n, costs);
        }

        private int process(int n, int[][] costs) {
            init(n, costs);
            int sum = 0;
            for(int[] costInfo : costs) {
                int from = costInfo[0];
                int to = costInfo[1];
                int cost = costInfo[2];

                int fromParent = findParent(from);
                int toParent = findParent(to);

                if(fromParent == toParent)
                    continue;

                parent[toParent] = fromParent;
                sum += cost;
            }
            return sum;
        }

        private void init(int n, int[][] costs) {
            parent = new int[n];
            for(int i = 0 ; i < n; i++) {
                parent[i] = i;
            }
            Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));
        }

        private int findParent(int idx) {
            if(parent[idx] == idx)
                return idx;
            return parent[idx] = findParent(parent[idx]);
        }
    }
}
