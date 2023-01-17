package programmers;
import java.util.*;

public class Programmers2_5 {

    class Solution {
        private Map<Integer, Integer> map = new HashMap<>();
        private int answer = 0;
        private List<Integer> list;

        public int solution(int k, int[] tangerine) {
            init(tangerine);
            makeAnswer(k);
            return answer;
        }

        private void init(int[] tangerine) {
            for(int i = 0 ; i < tangerine.length; i++) {
                int val = tangerine[i];
                if(map.get(val) == null)
                    map.put(val, 0);
                map.put(val, map.get(val) + 1);
            }
        }

        private void makeAnswer(int k) {
            list = new ArrayList<>(map.values());
            Collections.sort(list, (o1, o2) -> {
                return Integer.compare(-o1, -o2);
            });

            for(int i : list) {
                if(k <= 0)
                    break;
                k -= i;
                answer++;
            }
        }

    }
}
