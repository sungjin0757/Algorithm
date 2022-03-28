package programmers;
import java.util.*;
public class Lev3_15 {

    class Solution {
        PriorityQueue<Integer> max=new PriorityQueue<>((o1,o2)->{return Integer.compare(-o1,-o2);});
        PriorityQueue<Integer> min=new PriorityQueue<>();
        Queue<Integer> total=new LinkedList<>();
        public int[] solution(String[] operations) {
            for(String op : operations){
                String[] temp=op.split(" ");
                if(temp[0].equals("I")){
                    total.offer(Integer.parseInt(temp[1]));
                    continue;
                }
                if(temp[1].equals("1")){
                    while(!total.isEmpty()){
                        max.offer(total.poll());
                    }
                    max.poll();
                    while(!max.isEmpty()){
                        total.offer(max.poll());
                    }
                    continue;
                }
                while(!total.isEmpty()){
                    min.offer(total.poll());
                }
                min.poll();
                while(!min.isEmpty()){
                    total.offer(min.poll());
                }
            }
            List<Integer> temp=new ArrayList<>();
            while(!total.isEmpty()){
                temp.add(total.poll());
            }
            Collections.sort(temp);
            int[] answer=new int[2];
            if(temp.size()==0)
                return answer;
            else if(temp.size()==1){
                if(temp.get(0)<0)
                    answer[1]=temp.get(0);
                else
                    answer[0]=temp.get(0);
            }else{
                answer[0]=temp.get(temp.size()-1);
                answer[1]=temp.get(0);
            }
            return answer;
        }
    }
}
