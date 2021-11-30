package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SimulationPractice {

    int n,m;
    int[] arr;
    int[] temp;
    int res=Integer.MAX_VALUE;

    private void dfs(int x){
        if(x==m){
            if(sum1(m)==n)
                res=Math.min(res,sum2());
            return;
        }
        else if(x!=m) {
            for (int i = 1; i <= n - (m - 1); i++) {
                if(sum1(x)+i<=n) {
                    temp[x] = i;
                    dfs(x + 1);
                }
            }
        }
    }

    private int sum1(int size){
        int t=0;
        for(int i=0;i<size;i++)
            t+=temp[i];

        return t;
    }

    private int sum2(){
        int idx=0;
        int t=0;

        for(int i=0;i<m;i++){
            if(temp[i]==1){
                t+=1;
            }else if(temp[i]!=1){
                t+=(arr[idx+temp[i]-1]-arr[idx])+1;
            }
            idx+=temp[i];
        }

        return t;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        if(m>=n){
            System.out.println(n);
            return;
        }

        arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        temp=new int[m];

        dfs(0);

        System.out.println(res);

    }
}
