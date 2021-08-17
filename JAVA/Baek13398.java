package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek13398 {

    int n;
    int arr[];
    int[] dpL;
    int[] dpR;


    private int dfsL(int x){
        if(x==1)
            return dpL[1]=arr[1];
        if(dpL[x]>Integer.MIN_VALUE)
            return dpL[x];

        dpL[x]=Math.max(dfsL(x-1)+arr[x],arr[x]);

        return dpL[x];
    }

    private int dfsR(int x){
        if(x==n)
            return dpR[n]=arr[n];
        if(dpR[x]>Integer.MIN_VALUE)
            return dpR[x];


        dpR[x]=Math.max(dfsR(x+1)+arr[x],arr[x]);

        return dpR[x];
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");

        arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dpL=new int[n+1];
        dpR=new int[n+1];
        Arrays.fill(dpL,Integer.MIN_VALUE);
        Arrays.fill(dpR,Integer.MIN_VALUE);


        dfsL(n);
        int res= Arrays.stream(dpL).max().getAsInt();

        dfsR(1);

        for(int i=2;i<n;i++){
            res=Math.max(res,dpL[i-1]+dpR[i+1]);
        }


        System.out.println(res);
    }

}