package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Baek16947 {

    int n;
    int[][] subway;
    int jisun1=0;
    int jisun2=0;
    int[] visit;

    public int[] bfs(int x){
        Queue<Integer> dq=new LinkedList<>();
        dq.offer(x);
        int []dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        boolean[] check=new boolean[n+1];
        dis[x]=0;

        while(!dq.isEmpty()){
            int temp=dq.poll();
            check[temp]=true;

            for(int i=1;i<=n;i++){
                if(subway[temp][i]!=0 ){
                    if(!check[i]) {
                        dq.offer(i);
                        dis[i]=Math.min(dis[temp]+1,dis[i]);
                    }

                }
            }

        }


        return dis;
    }

    public int dfs(int x, int before){
        if(visit[x]==1)
            return x;

        visit[x]=1;
        for(int i=1;i<=n;i++){
            if(subway[x][i]==1){
                if(i==before)
                    continue;
                int result=dfs(i,x);

                if(result==-2)
                    return -2;
                if(result>0){
                    visit[x]=2;
                    if(x==result)
                        return -2;
                    else
                        return result;
                }
            }
        }
        return -1;
    }

    public void solve() throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        subway=new int[n+1][n+1];
        visit=new int[n+1];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());
            subway[temp1][temp2]=1;
            subway[temp2][temp1]=1;
        }

        dfs(1,0);

        for(int i=1;i<=n;i++){
            if(visit[i]==2){
                int check=0;
                for(int j=1;j<=n;j++){
                    if(subway[i][j]!=0){
                        check+=1;
                    }
                }
                if(check>=3){
                    if(jisun1==0){
                        jisun1=i;
                    }
                    else
                        jisun2=i;
                }
            }
        }

        StringBuilder sb=new StringBuilder();

        if(jisun1==0 && jisun2==0){
            for(int i=1;i<=n;i++){
                sb.append(String.valueOf(0)+" ");
            }
        }
        else {

            int[] bfs1 = bfs(jisun1);
            int[] bfs2 = bfs(jisun2);

            for (int i = 1; i <= n; i++) {
                if(visit[i]==2)
                    sb.append(String.valueOf(0)+" ");
                else
                    sb.append(String.valueOf(Math.min(bfs1[i],bfs2[i])) + " ");
            }

        }
        System.out.println(sb.toString().substring(0,sb.length()-1));
    }

}
