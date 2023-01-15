package programmers;

public class Programmers2_3 {
    class Solution {
        public int solution(int storey) {
            int answer = 0;

            while(storey != 0) {
                int n = storey % 10;

                if(n >= 6) {
                    storey += (10 - n);
                    answer += (10 - n);
                } else if(n == 5 && ((storey / 10) % 10 >= 5)) {
                    storey += (10 - n);
                    answer += (10 - n);
                } else {
                    answer += n;
                }

                storey /= 10;
            }
            return answer;
        }
    }
}
