package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10870 {

    int n;

    private  int fibonacci(int number){
        if(number==1){
            return 1;
        }else if(number==2){
            return 2;
        }else{
            return fibonacci(number-1)+ fibonacci(number-2);
        }
    }


    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        if(n==0){
            System.out.println(0);
            return;
        }
        System.out.println(fibonacci(n-1));
    }
}
