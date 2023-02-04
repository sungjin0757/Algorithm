package programmers;

public class Programmers3_15 {
    class Solution {
        private int[] l_min;
        private int[] r_min;
        private int answer = 2;

        public int solution(int[] a) {
            init(a);
            process(a);
            return answer;
        }

        private void init(int[] a) {
            l_min = new int[a.length];
            r_min = new int[a.length];
            initLeft(a);
            initRight(a);
        }

        private void initLeft(int[] a) {
            l_min[0] = a[0];
            for(int i = 1 ; i < a.length; i++) {
                l_min[i] = Math.min(l_min[i - 1], a[i]);
            }
        }

        private void initRight(int[] a) {
            r_min[a.length - 1] = a[a.length - 1];
            for(int i = a.length - 2 ; i >= 0; i--) {
                r_min[i] = Math.min(r_min[i + 1], a[i]);
            }
        }

        private void process(int[] a) {
            for(int i = 1; i < a.length - 1; i++) {
                middleIdxProcess(i, a);
            }
        }

        private void middleIdxProcess(int idx, int[] a) {
            if((a[idx] < l_min[idx - 1]) || (a[idx] < r_min[idx + 1])) {
                answer++;
            }
        }
    }
}
