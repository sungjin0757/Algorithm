package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2606 {
    int cnt=0;

    public void dfs(int[][] a,boolean[] check,int n){
       for(int i=1;i<a[n].length;i++){
           if(a[n][i]==1 && check[i]==false){
               check[i]=true;
               cnt++;
               dfs(a,check,i);
           }
       }
    }

    public void solve() throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());

        int[][] list=new int[n+1][n+1];

        for(int i=0;i<m;i++){
            String temp[]=br.readLine().split(" ");
            int tmp1 = Integer.parseInt(temp[0]);
            int tmp2 = Integer.parseInt(temp[1]);
            list[tmp1][tmp2]=1;
            list[tmp2][tmp1]=1;
        }

        boolean[] check=new boolean[n+1];
        check[1]=true;

        dfs(list,check,1);

        System.out.println(cnt);

    }
}
