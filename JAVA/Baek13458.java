package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek13458 {

    int n,b,c;
    long[] arr;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new long[n];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine()," ");

        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        long res=0;
        Map<Long,Long> map=new HashMap<>();

        for(int i=0;i<n;i++){
            long temp=arr[i];
            if(map.containsKey(temp)){
                res+=map.get(temp);
                continue;
            }
            long t=0;
            t++;
            if(temp-b>0) {
                temp -= b;
                while (temp > 0) {
                    temp -= c;
                    t++;
                }
            }
            res+=t;
            map.put(arr[i],t);
        }

        System.out.println(res);

    }
}
