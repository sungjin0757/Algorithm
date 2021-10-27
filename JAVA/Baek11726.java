package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baek11726 {

    int n;
    int[] arr;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1];

        if(n==1)
            System.out.println(1);
        else if(n==2)
            System.out.println(2);
        else{
            arr[1]=1;
            arr[2]=2;

            for(int i=3;i<=n;i++){
                arr[i]=(arr[i-2]+arr[i-1])/10007;
            }
            System.out.println(arr[n]/10007);
        }
    }
}
