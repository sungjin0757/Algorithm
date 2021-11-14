package dp;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9625 {

    int n;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        if(n==1)
        {
            System.out.println("0 1");
        }
        else{
            StringBuilder sb=new StringBuilder("BA");
            for(int i=0;i<n-2;i++){
                int aC=getCount(sb.toString(),"A");
                int bC=getCount(sb.toString(),"B");

                sb=new StringBuilder();
                for(int j=0;j<aC;j++){
                    sb.append("B");
                }
                for(int j=0;j<bC;j++){
                    sb.append("BA");
                }
            }
            System.out.print(getCount(sb.toString(),"A")+" "+getCount(sb.toString(),"B"));
        }
    }

    private int getCount(String s1,String s2){
        return s1.length()-s1.replace(s2,"").length();
    }
}
