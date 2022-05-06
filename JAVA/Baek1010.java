package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1010 {

    long t,n,m;

    private BigInteger factorial(long num){
        if(num==1)
            return BigInteger.valueOf(1);
        return factorial(num-1).multiply(BigInteger.valueOf(num));
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<BigInteger> res=new ArrayList<>();

        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine()," ");
            n=Long.parseLong(st.nextToken());
            m=Long.parseLong(st.nextToken());
            if(n==m){
                res.add(BigInteger.valueOf(1));
                continue;
            }
            if(n==1){
                res.add(BigInteger.valueOf(m));
                continue;
            }
            res.add(factorial(m).divide(factorial(n).multiply(factorial(m-n))));
        }

        for (BigInteger re : res) {
            System.out.println(re.intValue());
        }
    }
}
