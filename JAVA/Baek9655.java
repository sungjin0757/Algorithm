package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9655 {

    int n;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        if(n%2==1)
            System.out.println("SK");
        else if(n%2==0)
            System.out.println("CY");
    }
}
