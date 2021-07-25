package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11054Dfs {

    int n;
    int[] arr;
    int[] dl;
    int[] dr;

    public int DFSL(int x){
        if(dl[x]==0)
            dl[x]=1;
        for(int i=x-1;i>0;i--){
            if(arr[x]>arr[i]){
                dl[x]=Math.max(dl[x],DFSL(i)+1);
            }
        }

        return dl[x];
    }

    public int DFSR(int x){
        if(dr[x]==0)
            dr[x]=1;

        for(int i=x+1;i<arr.length;i++){

            if(arr[x]>arr[i]){
                dr[x]=Math.max(dr[x],DFSR(i)+1);
            }
        }
        return dr[x];
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        arr=new int[n+1];
        dl=new int[n+1];
        dr=new int[n+1];


        for(int i=1;i<n+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int length=0;


        for(int i=1;i<=n;i++){
            if(dl[i]==0)
                DFSL(i);
            if(dr[i]==0)
                DFSR(i);
        }



        for (int i=1;i<=n;i++) {
            length=Math.max(length,dl[i]+dr[i]);
        }


        System.out.println(length-1);

    }
}
