package programmers;

public class Programmers3_2 {
    class Solution {
        private int[][] cost = new int[][] {
                { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
                { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
                { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
                { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
                { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
                { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
                { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
                { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
                { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
                { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
        };
        private int[][][] dp;
        private String numbers;
        private int len;

        public int solution(String numbers) {
            int answer = 0;
            int len = numbers.length();
            dp = new int[len + 1][10][10];
            init(len, numbers);

            return dfs(0, 4, 6);
        }

        private void init(int len, String numbers) {
            this.numbers = numbers;
            this.len = len;
            for(int i = 0; i <= len; i++) {
                for(int j = 0; j < 10; j++) {
                    for(int k = 0; k < 10; k++) {
                        dp[i][j][k] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        private int dfs(int idx, int left, int right) {
            if(idx == len)
                return 0;
            if(dp[idx][left][right] != Integer.MAX_VALUE)
                return dp[idx][left][right];
            int num = numbers.charAt(idx) - '0';

            if (num != left) {
                dp[idx][left][right] = Math.min((dfs(idx + 1, left, num) + cost[right][num]), dp[idx][left][right]);
            }
            if (num != right) {
                dp[idx][left][right] = Math.min((dfs(idx + 1, num, right) + cost[left][num]), dp[idx][left][right]);
            }

            return dp[idx][left][right];
        }
    }
}
