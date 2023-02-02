package programmers;
import java.util.*;

public class Programmers2_8 {

    class Solution {
        private int[] dp;

        public int solution(int x, int y, int n) {
            init(x, y);
            process(x, y, n);

            return dp[y] == 10000000 ? -1 : dp[y];
        }

        private void init(int x, int y) {
            dp = new int[y + 1];
            Arrays.fill(dp, 10000000);
            dp[x] = 0;
        }

        private void process(int x, int y, int n) {
            for(int i = x; i <= y - n; i++) {
                plusN(i, y, n);
                multiplyTwo(i, y, n);
                multiplyThree(i, y, n);
            }
        }

        private void plusN(int x, int y, int n) {
            int temp = x + n;
            if(!isInRange(temp, y))
                return;
            dp[temp] = Math.min(dp[temp], dp[x] + 1);
        }

        private void multiplyTwo(int x, int y, int n) {
            int temp = x * 2;
            if(!isInRange(temp, y))
                return;
            dp[temp] = Math.min(dp[temp], dp[x] + 1);
        }

        private void multiplyThree(int x, int y, int n) {
            int temp = x * 3;
            if(!isInRange(temp, y))
                return;
            dp[temp] = Math.min(dp[temp], dp[x] + 1);
        }


        private boolean isInRange(int val, int y) {
            if(val > y)
                return false;
            return true;
        }
    }
}
