package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1495 {

    int n,s,m;
    int[] v,res;


    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        v=new int[n+1];
        res=new int[m+1];

        st=new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.fill(res,-1);
        res[s]=0;

        for(int i=1;i<=n;i++){
            List<Integer> arr=new ArrayList<>();

            for(int j=0;j<=m;j++){
                if(res[j]==i-1){
                    if(0<=j+v[i] && j+v[i]<=m)
                        arr.add(j+v[i]);
                    if(0<=j-v[i] && j-v[i]<=m)
                        arr.add(j-v[i]);
                }
            }

            for(int a:arr){
                res[a]=i;
            }
        }

        for(int i=m;i>=0;i--){
            if(res[i]==n){
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
