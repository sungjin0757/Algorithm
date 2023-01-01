package programmers;
import java.util.*;
public class Programmers3_1 {
    class Solution {
        private int[] answer;
        private Number[] dp;

        public int[] solution(int e, int[] starts) {
            answer = new int[starts.length];
            dp = new Number[e + 1];

            getResult(e, starts);

            return answer;
        }

        private void getResult(int e, int[] starts) {
            calDp(e);
            sortDp();
            for(int i = 0; i < starts.length; i++) {
                int s = starts[i];
                for(int j = 0; j < dp.length; j++) {
                    int num = dp[j].num;
                    if(num >= s && num <=e) {
                        answer[i] = num;
                        break;
                    }
                }
            }
        }

        private void calDp(int e) {
            for(int i = 0; i <= e; i++) {
                dp[i] = new Number(i, 0);
            }

            for(int i = 1; i <= e; i++) {
                for(int j = i; j <= e; j+=i) {
                    dp[j].cnt++;
                }
            }
        }

        private void sortDp() {
            Arrays.sort(dp, new Comparator<Number>() {
                @Override
                public int compare(Number o1, Number o2) {
                    if(o1.cnt == o2.cnt)
                        return Integer.compare(o1.num, o2.num);
                    return Integer.compare(-o1.cnt, -o2.cnt);
                }
            });
        }

        private class Number {
            int num;
            int cnt;

            public Number(int num, int cnt) {
                this.num = num;
                this.cnt = cnt;
            }
        }
    }
}
