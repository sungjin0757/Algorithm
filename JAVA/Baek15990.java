package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baek15990 {

    int t;
    long[][] temp;
    List<Integer> res=new ArrayList<>();

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            res.add(Integer.parseInt(br.readLine()));
        }
        temp=new long[Collections.max(res)+1][4];
        temp[1][1]=1;
        if(temp.length>=2)
            temp[2][2]=1;
        if(temp.length>=3){
            temp[3][1]=1;
            temp[3][2]=1;
            temp[3][3]=1;
        }
        for(int i=4;i<temp.length;i++){
            temp[i][1]=(temp[i-1][2]+temp[i-1][3])%1000000009;
            temp[i][2]=(temp[i-2][1]+temp[i-2][3])%1000000009;
            temp[i][3]=(temp[i-3][1]+temp[i-3][2])%1000000009;
        }
        for(int i=0;i<res.size();i++){
            Integer r = res.get(i);
            System.out.println((temp[r][1]+temp[r][2]+temp[r][3])%1000000009);
        }
    }
}
