package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Baek10942 {

    int n,m;
    int[] arr;
    List<Integer> a=new LinkedList<>();

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        m=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++)
        {
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            boolean flag=true;
            for(int j=a;j<=(a+b)/2;j++){
                if(arr[j]!=arr[b-j+a])
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.println(sb);
    }
}
