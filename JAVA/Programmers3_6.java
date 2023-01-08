package programmers;
import java.util.*;
public class Programmers3_6 {
    class Solution {
        private int[] dx = new int[] {0, 0, -1, 1};
        private int[] dy = new int[] {-1, 1, 0, 0};
        private Map<Integer, String> dirMap = new HashMap<>();
        private List<String> answers = new ArrayList<>();
        private int n, m, limit;

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            init(n, m, k);
            dfs(x, y, r, c, 0, new StringBuilder());
            Collections.sort(answers);
            String answer = answers.isEmpty() ? "impossible" : answers.get(0);
            return answer;
        }

        private void init(int n, int m, int k) {
            dirMap.put(0, "l");
            dirMap.put(1, "r");
            dirMap.put(2, "u");
            dirMap.put(3, "d");
            this.n = n;
            this.m = m;
            this.limit = k;
        }

        private void dfs(int x, int y, int r, int c, int k, StringBuilder sb) {
            if(k > limit) {
                return;
            }
            if((k == limit) && ((x == r) && (y == c))) {
                answers.add(sb.toString());
                return;
            }
            // System.out.println(sb.toString());
            StringBuilder builder = new StringBuilder(sb.toString());
            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx <= 0 || xx > n || yy <= 0 || yy > m) {
                    // System.out.println(1);
                    continue;
                }
                builder.append(dirMap.get(i));
                dfs(xx, yy, r, c, k + 1, builder);
                builder.deleteCharAt(sb.length());
            }
        }

    }
}
