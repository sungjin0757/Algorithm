package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek11049 {

    int n;
    List<int []> arr=new ArrayList<>();

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int[] temp=new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            arr.add(temp);
        }

        int[] dp=new int[n];
        if(n==1){
            System.out.println(0);
        }
        else {
            dp[1] = arr.get(0)[0] * arr.get(0)[1] * arr.get(1)[1];
            for(int i=2;i<n;i++){
                int[] temp=arr.get(i);
                dp[i]=Math.min(dp[i-1]+arr.get(0)[0]*temp[0]*temp[1],dp[i-2]+arr.get(0)[0]*arr.get(i-1)[0]*temp[1]+arr.get(i-1)[0]*temp[0]*temp[1]);
            }
            System.out.println(dp[n-1]);
        }
    }
}
