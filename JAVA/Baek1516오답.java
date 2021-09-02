package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Baek1516 {

    int n;
    List<int[]>[] arr;


    public void solve() throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        arr=new ArrayList[n+1];
        int[] dp=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
            st=new StringTokenizer(br.readLine()," ");
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());
            int[] arrTemp=new int[2];
            if(temp2==-1){
                arrTemp[0]=0;
                arrTemp[1]=temp1;
            }
            else{
                arrTemp[0]=temp2;
                arrTemp[1]=temp1;
            }
            arr[i].add(arrTemp);
        }

        while(true)
        {
            boolean check=true;
            for(int i=1;i<=n;i++){
                if(dp[i]==0){
                    check=false;
                    break;
                }
            }
            if(check){
                break;
            }
            for(int i=1;i<=n;i++){
                int temp=arr[i].get(0)[0];
                if(temp==0){
                    if(dp[i]!=0)
                        continue;
                    dp[i]=arr[i].get(0)[1];
                }
                else{
                    if(dp[temp]!=0){
                        arr[i].get(0)[0]=0;
                        arr[i].get(0)[1]+=dp[temp];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            System.out.println(dp[i]);
        }
    }
}
