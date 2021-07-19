package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek_1783 {

    public void solve() throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String temp[]=br.readLine().split(" ");
        int n=Integer.parseInt(temp[0]);
        int m=Integer.parseInt(temp[1]);

        int count=1;
        if(n==2 ){
            count=Math.min(4,(m+1)/2);
        }
        else if(n>=3 && m<7) {
            count=Math.min(4,m);
        }
        else if(n>=3 && m>=7){
            count=m+5-7;
        }

        System.out.println(count);

    }
}
