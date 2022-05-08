package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek11727 {

    int n;
    int[] arr;

    public void solve() throws IOException{
        n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        arr=new int[n+1];
        arr[1]=1;
        if(n>=2){
            arr[2]=3;
            for(int i=3;i<=n;i++){
                arr[i]=arr[i-1]%10007+(2*arr[i-2])%10007;
            }
        }

        System.out.println(arr[n]);
    }
}
