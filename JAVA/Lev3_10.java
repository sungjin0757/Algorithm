package programmers;
import java.util.*;
public class Lev3_10 {

    class Solution {
        int[][] graph;
        public int solution(int n, int[][] results) {
            int answer=0;
            graph=new int[n+1][n+1];

            Arrays.stream(graph).forEach(g->Arrays.fill(g,1000000));
            for(int[] result : results){
                // graph[result[0]][result[1]]=1;
                graph[result[1]][result[0]]=1;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j){
                        graph[i][j]=0;
                    }
                }
            }

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    for(int k=1;k<=n;k++){
                        graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);
                    }
                }
            }
            for(int i=1;i<=n;i++){
                int cnt=0;
                for(int j=1;j<=n;j++){
                    if(i==j)
                        continue;
                    if(graph[i][j]!=1000000 || graph[j][i]!=1000000)
                        cnt++;
                }
                if(cnt==n-1)
                    answer+=1;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    System.out.print(graph[i][j]+" ");
                }
                System.out.println();
            }
            return answer;
        }
    }
}
