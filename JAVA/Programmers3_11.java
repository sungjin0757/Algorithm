package programmers;
import java.util.*;
public class Programmers3_11 {
    class Solution {
        private int[][] dp;
        private int maxAlp, maxCop;


        public int solution(int alp, int cop, int[][] problems) {
            init(alp, cop, problems);

            alp = Math.min(maxAlp, alp);
            cop = Math.min(maxCop, cop);
            dp[alp][cop] = 0;
            process(alp, cop, problems);
            return dp[maxAlp][maxCop];
        }

        private void init(int alp, int cop, int[][] problems) {
            maxAlp = 0;
            maxCop = 0;

            for(int[] problem : problems) {
                maxAlp = Math.max(maxAlp, problem[0]);
                maxCop = Math.max(maxCop, problem[1]);
            }

            dp = new int[1000][1000];
            Arrays.stream(dp).forEach(d -> {
                Arrays.fill(d, 100000);
            });


        }

        private void process(int alp, int cop, int[][] problems) {
            for(int i = alp; i <= maxAlp; i++) {
                for(int j = cop; j <= maxCop; j++) {
                    if(i < maxAlp)
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                    if(j < maxCop)
                        dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                    for(int k = 0; k < problems.length; k++) {
                        int alpK = problems[k][0];
                        int copK = problems[k][1];
                        if(alpK > i || copK > j)
                            continue;
                        int row = Math.min(i + problems[k][2], maxAlp);
                        int col = Math.min(j + problems[k][3], maxCop);
                        dp[row][col] = Math.min(dp[row][col], dp[i][j] + problems[k][4]);
                    }
                }
            }
        }

    }
}
