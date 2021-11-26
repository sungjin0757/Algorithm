package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1110 {

    int n;
    int res=0;

    private int sol(int n){
        res++;

        int left=n/10;
        int right=n%10;

        return right*10+((left+right)%10);
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        if(n<10)
            n*=10;

        int temp=n;

        while(true){
            n=sol(n);
            if(n==temp)
                break;
        }

        System.out.println(res);
    }
}
