package programmers;
import java.util.*;

public class Programmers3_12 {

    class Solution {
        private int[] info;
        private int[][] edges;
        private int answer = 0;

        public int solution(int[] info, int[][] edges) {
            init(info, edges);
            process();
            return answer;
        }

        private void init(int[] info, int[][] edges) {
            this.info = info;
            this.edges = edges;
        }

        private void process() {
            List<Integer> possible = new ArrayList<>();
            possible.add(0);

            dfs(1, 0, 0, possible);
        }

        private void dfs(int sheep, int wolf, int present, List<Integer> possible) {
            if(wolf >= sheep) {
                return;
            } else {
                answer = Math.max(sheep, answer);
            }

            List<Integer> possibleTemp = new ArrayList<>(possible);

            for(int[] edge : edges) {
                int pre = edge[0];
                int ne = edge[1];
                if(present != pre)
                    continue;
                possibleTemp.add(ne);
            }

            possibleTemp.remove(Integer.valueOf(present));

            for(Integer node : possibleTemp) {
                dfs(sheep + (info[node] ^ 1), wolf + info[node], node, possibleTemp);
            }
        }
    }
}
