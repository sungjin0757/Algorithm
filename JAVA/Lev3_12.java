package programmers;
import java.util.*;
public class Lev3_12 {

    class Solution {
        int n;
        Set<String> set=new HashSet<>();

        public int[] solution(String[] gems) {
            int[] answer = new int[2];
            n=gems.length;
            for(String gem : gems){
                set.add(gem);
            }
            int startIdx=0;
            int endIdx=0;
            Set<String> temp=new HashSet<>();
            PriorityQueue<int[]> dq=new PriorityQueue<>((o1,o2)->{
                if(o1[2]==o2[2])
                    return Integer.compare(o1[0],o2[0]);
                return Integer.compare(o1[2],o2[2]);
            });
            Map<String,ArrayList<Integer>> map=new HashMap<>();
            for(int i=startIdx;i<n;i++){
                while(temp.size()<set.size() && endIdx<n){
                    temp.add(gems[endIdx]);
                    if(!map.containsKey(gems[endIdx])){
                        map.put(gems[endIdx],new ArrayList<>());
                    }
                    map.get(gems[endIdx]).add(endIdx);
                    endIdx++;
                }
                if(temp.size()==set.size()){
                    System.out.println(1);
                    dq.offer(new int[]{i+1,endIdx,endIdx-i});
                }
                ArrayList<Integer> tem=map.get(gems[i]);
                tem.remove(Integer.valueOf(i));
                if(tem.size()==0)
                    temp.remove(gems[i]);
            }
            answer[0]=dq.peek()[0];
            answer[1]=dq.peek()[1];
            return answer;
        }
    }
}
