package programmers;
import java.util.*;
public class Lev3_7 {

    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            PriorityQueue<int[]> dq=new PriorityQueue<>((o1,o2)->{
                return Integer.compare(o1[0],o2[0]);
            });

            for(int[] job : jobs){
                dq.offer(job);
            }

            PriorityQueue<int[]> tempDq=new PriorityQueue<>((o1,o2)->{
                return Integer.compare(o1[1],o2[1]);
            });
            int time=0;
            while(!dq.isEmpty()){
                while(true){
                    if(dq.size()==0)
                        break;
                    int[] temp=dq.poll();
                    if(temp[0]<=time){
                        tempDq.offer(temp);
                    }
                    if(temp[0]>time){
                        dq.offer(temp);
                        break;
                    }
                }
                if(tempDq.size()==0){
                    time++;
                    continue;
                }
                int[] temp=tempDq.poll();
                time+=temp[1];
                answer+=time-temp[0];
                while(!tempDq.isEmpty()){
                    temp=tempDq.poll();
                    dq.offer(temp);
                }

            }
            return answer/jobs.length;
        }
    }
}
