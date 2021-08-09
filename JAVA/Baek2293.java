package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Baek2293 {

    int n,k;
    int[] arr;
    int[] dp;

    public int dfs(int sum,int temp){

        if(sum==0)
            return 1;
        else if(sum<0) {
            return 0;
        }
        if(sum==k){
            for(int i=0;i<arr[temp];i++) {
                if(sum-i>=0) {
                    dp[sum - i] += dfs((sum - i) - arr[temp], temp);
                }
            }
        }
        else{
            dp[sum] += dfs(sum - arr[temp], temp);
        }

        return dp[sum];
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        }
        Arrays.sort(arr);

        dp=new int[k+1];

        for(int i=1;i<=n;i++) {
            dfs(k, i);
        }
        System.out.println(dp[k]);
    }
}
