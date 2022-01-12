package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15486 {

    int n;
    List<int[]> arr;
    int[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            arr.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        dp=new int[n+2];
        dp[1]=arr.get(0)[1];

        for(int i=n;i>=1;i--){
            int[] temp = arr.get(i - 1);
            if(temp[0]+i>n+1){
                dp[i]=dp[i+1];
            }else{
                dp[i]=Math.max(dp[i+1],temp[1]+dp[temp[0]+i]);
            }
        }
        System.out.println(dp[1]);
    }
}
