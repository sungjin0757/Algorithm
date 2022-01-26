package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek10217 {

    int t,n,m,k;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());

            List<int[]>[] graph=new ArrayList[n+1];
            for(int j=1;j<=n;j++)
                graph[j]=new ArrayList<>();

            int[][] distance=new int[n+1][m+1];
            distance[1][0]=0;

            for(int j=1;j<=k;j++){
                st=new StringTokenizer(br.readLine()," ");
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());
                int d=Integer.parseInt(st.nextToken());

                graph[u].add(new int[]{d,v,c});
            }
            for(int j=1;j<=n;j++){
                Arrays.fill(distance[j],1,m+1,Integer.MAX_VALUE);
            }
            Queue<int[]> dq=new PriorityQueue<>((o1, o2) ->
            {return Integer.compare(o1[0],o2[0]);}
            );
            dq.offer(new int[]{0,1,0});
            int res=Integer.MAX_VALUE;

            while(!dq.isEmpty()){
                int[] temp=dq.poll();
                int dis=temp[0];
                int edge=temp[1];
                int cost=temp[2];

                if(edge==n){
                    res=Math.min(res,dis);
                    break;
                }
                for(int[] row:graph[edge]){
                    int d=row[0]+ dis;
                    int c=row[2]+cost;
                    if(c>m)
                        continue;
                    if(distance[row[1]][c]>d) {
                        distance[row[1]][c]=d;
                        dq.offer(new int[]{d, row[1], c});
                    }
                }


            }
            if(res==Integer.MAX_VALUE) {
                System.out.println("Poor KCM");
                continue;
            }
            System.out.println(res);
        }
    }
}
