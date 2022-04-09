package programmers;
import java.util.*;
public class Lev3_21 {

    class Solution {
        int[][] dp,arr;
        public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
            dp=new int[k][n+1];
            arr=new int[n+1][n+1];
            for(int[] e : edge_list){
                arr[e[0]][e[1]]=1;
                arr[e[1]][e[0]]=1;
            }
            Arrays.stream(dp).forEach(d->Arrays.fill(d,20000000));
            dp[0][gps_log[0]]=0;
            for(int i=1;i<k;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]);
                    for(int kk=1;kk<=n;kk++){
                        if(arr[j][kk]==1){
                            dp[i][j]=Math.min(dp[i][j],dp[i-1][kk]);
                        }
                    }
                    if(j!=gps_log[i]){
                        dp[i][j]++;
                    }
                }
            }


            if(dp[k-1][gps_log[k-1]]<20000000)
                return dp[k-1][gps_log[k-1]];
            return -1;
        }
    }
}
