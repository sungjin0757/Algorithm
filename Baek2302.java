package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2302 {

    int n,m;
    long[] dp;
    int[] temp;
    List<Integer> res=new ArrayList<>();

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());

        temp=new int[m+1];
        for(int i=0;i<m;i++){
            temp[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(temp,0,m);

        int c=temp[0];
        int t=0;
        int idx=1;
        for(int i=1;i<=n;i++){
            if(i==c || i==n){
                if(i==n && i!=c)
                    t++;
                res.add(t);
                if(i!=n) {
                    c = temp[idx];
                    idx++;
                }
                t=0;
                continue;
            }
            t++;
        }
        Collections.sort(res,(o1,o2)->{
            return Integer.compare(-o1,-o2);
        });

        dp=new long[res.get(0)+1];
        dp[0]=1;
        if(dp.length>1)
            dp[1]=1;
        for(int i=2;i<=res.get(0);i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        if(res.get(0)==0){
            System.out.println(1);
            return;
        }
        long rres=1;
        for(int i=0;i<res.size();i++){
            rres*=dp[res.get(i)];
        }
        System.out.println(rres);
    }
}
