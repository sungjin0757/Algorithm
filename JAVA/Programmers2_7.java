package programmers;
import java.util.*;
public class Programmers2_7 {

    class Solution {
        private int[] answer;
        private PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        public int[] solution(int[] numbers) {
            answer = new int[numbers.length];
            process(numbers);
            return answer;
        }

        private void process(int[] numbers) {
            for(int i = 0 ; i < numbers.length; i++) {
                int value = numbers[i];

                while(!pq.isEmpty() && pq.peek()[1] < value) {
                    answer[pq.poll()[0]] = value;
                }

                pq.add(new int[]{i, value});
            }

            while(!pq.isEmpty()) {
                answer[pq.poll()[0]] = -1;
            }
        }

    }
}
