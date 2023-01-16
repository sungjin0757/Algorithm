package programmers;

public class Programmers2_4 {
    class Solution {
        private int n;
        private long l, r;
        private int answer = 0;

        public int solution(int n, long l, long r) {
            this.l = l;
            this.r = r;
            return (int) (makeAnswer(r) - makeAnswer(l - 1));
        }

        private long makeAnswer(long num) {
            if(num <= 5) {
                String s = "11011";
                int cnt = 0;
                for(int i = 0; i < num; i++) {
                    int t = s.charAt(i) -'0';
                    if(t == 1)
                        cnt++;
                }
                return cnt;
            }
            long depth = 1;
            long temp = 1;
            while(temp < num) {
                temp = (long) Math.pow(5, depth + 1);
                depth++;
            }
            depth -= 1;

            long val = num / (long) Math.pow(5, depth);
            long remainder = num % (long) Math.pow(5, depth);

            long res = ((long) Math.pow(4, depth)) * val;

            if(val >= 3)
                res -= (long) Math.pow(4, depth);

            if(val == 2)
                return res;
            else
                return res + makeAnswer(remainder);

        }

    }
}
