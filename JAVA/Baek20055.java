package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek20055 {
    int n,k;
    int[][] a;
    int[][] check;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        a=new int[2][n];
        check=new int[2][n];
        st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<n;i++)
            a[0][i]=Integer.parseInt(st.nextToken());

        for(int i=n-1;i>=0;i--){
            a[1][i]=Integer.parseInt(st.nextToken());
        }

        int res=0;

        while(true){

            if(isFinal())
                break;
            rotation(a);
            rotation(check);
            getOut();

            robotMove();
            getOut();

            if(a[0][0]>0 && check[0][0]!=1){
                check[0][0]=1;
                a[0][0]-=1;
            }
            res++;
        }


        System.out.println(res);
    }

    private void robotMove(){
        for(int i=n-2;i>=0;i--){
            if(check[0][i]==1) {
                if (a[0][i + 1] > 0 && check[0][i + 1] == 0) {
                    check[0][i + 1] = 1;
                    check[0][i] = 0;
                    a[0][i +1] -= 1;
                }
            }
        }
    }

    private void getOut(){
        if(check[0][n-1]==1)
            check[0][n-1]=0;
    }

    private boolean isFinal(){
        int sum=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]<=0)
                    sum++;
            }
            if(sum>=k)
                return true;
        }
        return false;
    }

    private void rotation(int[][] arr){
        int temp=arr[0][0];

        for(int i=1;i<n;i++){
            int temp1=arr[0][i];
            arr[0][i]=temp;
            temp=temp1;
        }

        int temp1=arr[1][n-1];
        arr[1][n-1]=temp;
        temp=temp1;

        for(int i=n-2;i>=0;i--){
            temp1=arr[1][i];
            arr[1][i]=temp;
            temp=temp1;
        }
        arr[0][0]=temp;
    }
}
