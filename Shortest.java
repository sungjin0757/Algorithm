package Sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class Shortest {
    public int[][] solve(int[][] points,int k){
        Queue<int[]> pq=new PriorityQueue<>((a,b)->
                (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));

        int[][] res=new int[k][2];

        for(int[] p: points){
            pq.offer(p);
        }

        int index=0;
        while(index<k){
            res[index]=pq.poll();
            index++;
        }

        return res;
    }
}
