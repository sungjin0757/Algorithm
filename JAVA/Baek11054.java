package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11054 {

    int n;
    int[] arr;

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        arr=new int[n+1];
        int[] dl=new int[n+1];
        int[] dr=new int[n+1];

        for(int i=1;i<n+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            dl[i]=1;
            for(int j=1;j<i;j++){
                if(arr[i]>arr[j]){
                    dl[i]=Math.max(dl[i],dl[j]+1);
                }
            }
        }

        for(int i=n;i>=1;i--){
            dr[i]=1;
            for(int j=n;j>i;j--){
                if(arr[i]>arr[j]){
                    dr[i]=Math.max(dr[i],dr[j]+1);
                }
            }
        }
        int length=0;

        for(int i=1;i<=n;i++){
            length=Math.max(length,dl[i]+dr[i]);
        }

        System.out.println(length-1);

    }
}
