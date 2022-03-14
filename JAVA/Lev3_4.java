package programmers;
import java.util.*;
public class Lev3_4 {
    class Solution {
        int[] node;
        List<int[]>[] graph;

        public int solution(int n, int[][] edge) {
            int answer = 0;
            node=new int[n+1];
            graph=new ArrayList[n+1];

            for(int i=1;i<=n;i++){
                graph[i]=new ArrayList<>();
            }

            for(int[] e : edge){
                graph[e[0]].add(new int[]{e[1],1});
                graph[e[1]].add(new int[]{e[0],1});
            }
            Arrays.fill(node,2,n+1,Integer.MAX_VALUE);
            PriorityQueue<int[]> dq=new PriorityQueue<>((o1,o2)->{return Integer.compare(o1[1],o2[1]);});
            dq.offer(new int[]{1,0});

            while(!dq.isEmpty()){
                int[] temp=dq.poll();
                int now=temp[0];
                int cost=temp[1];
                if(node[now]<cost)
                    continue;
                for(int[] row : graph[now]){
                    int dis=cost+row[1];
                    if(node[row[0]]>dis){
                        node[row[0]]=dis;
                        dq.offer(new int[]{row[0],dis});
                    }
                }
            }
            int max=Arrays.stream(node,1,n+1).max().getAsInt();
            return (int)Arrays.stream(node).filter(nn->nn==max).count();
        }
    }
}
