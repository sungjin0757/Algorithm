package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2565 {

    int n;
    List<int[]> arr;
    int[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new ArrayList<>();
        dp=new int[n];

        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr.add(new int[]{x,y});
        }

        Collections.sort(arr,(o1,o2)->{
            return Integer.compare(o1[0],o2[0]);
        });

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr.get(j)[1]<arr.get(i)[1])
                    dp[i]=Math.max(dp[j],dp[i]);
            }
            dp[i]+=1;
        }

        System.out.println(n- Arrays.stream(dp).max().getAsInt());
    }
}
