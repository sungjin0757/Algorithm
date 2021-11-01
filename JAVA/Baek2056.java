package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Baek2056 {

    int n;
    int[] degree;
    int[] time;
    int[] dp;
    List<Integer>[] graph;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        graph=new ArrayList[n+1];
        degree=new int[n+1];
        time=new int[n+1];
        dp=new int[n+1];


        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();

            st=new StringTokenizer(br.readLine()," ");
            int temp=Integer.parseInt(st.nextToken());
            time[i]=temp;
            int limit=Integer.parseInt(st.nextToken());
            degree[i]=limit;

            while(limit>0){
                graph[Integer.parseInt(st.nextToken())].add(i);
                limit--;
            }
        }

        Queue<Integer> dq=new LinkedList<>();

        for(int i=1;i<=n;i++){
            if(degree[i]==0){
                dq.offer(i);
                dp[i]=time[i];
            }
        }


        while(!dq.isEmpty()){
            int now=dq.poll();

            for(int row:graph[now]){
                degree[row]-=1;
                dp[row]=Math.max(dp[row],dp[now]+time[row]);
                if(degree[row]==0){
                    int temp=0;
                    dq.offer(row);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
