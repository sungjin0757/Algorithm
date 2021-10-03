package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15788 {

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        long[][] arr=new long[n+1][n+1];

        StringTokenizer st;
        int[] zero=new int[2];

        long sum=0;

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");

            long sumT=0;

            for(int j=1;j<=n;j++){
                int temp=Integer.parseInt(st.nextToken());
                if(temp==0) {
                    zero[0]=i;
                    zero[1]=j;
                    sumT=0;
                }

                arr[i][j]=temp;

                if(zero[0]==i)
                    continue;
                else{
                    sumT+=temp;
                }
            }

            if(sum==0 && sumT!=0)
                sum=sumT;
        }

        long temp=Arrays.stream(arr[zero[0]]).sum();
        arr[zero[0]][zero[1]]=sum-temp;

        if(arr[zero[0]][zero[1]]<=0){
            System.out.println(-1);
            System.exit(0);
        }
        boolean check=false;

        for(int i=1;i<=n;i++){
            long temp1=0;
            long temp2=0;
            for(int j=1;j<=n;j++){
                temp1+=arr[i][j];
                temp2+=arr[j][i];
            }

            if(sum!=temp1 || sum!=temp2)
            {
                check=true;
                break;
            }
        }

        if(check){
            System.out.println(-1);
            System.exit(0);
        }

        int temp1=0;
        int temp2=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    temp1+=arr[i][j];
                    temp2+=arr[i][n-i+1];
                }
            }
        }

        if(sum!=temp1 || sum!=temp2){
            System.out.println(-1);
            System.exit(0);
        }

        System.out.println(arr[zero[0]][zero[1]]);
    }
}
