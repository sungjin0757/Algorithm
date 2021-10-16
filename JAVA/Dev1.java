package programmers;
import java.util.*;

public class Dev1 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};

        Map<Integer,Integer> m=new HashMap<>();
        m.put(6,1);
        m.put(5,2);
        m.put(4,3);
        m.put(3,4);
        m.put(2,5);
        m.put(1,6);
        m.put(0,6);

        List<Integer> l=new ArrayList<>();
        List<Integer> w=new ArrayList<>();
        int count=0;

        for(int i=0;i<6;i++){
            if(lottos[i]==0)
                count++;
            l.add(lottos[i]);
            w.add(win_nums[i]);
        }

        int rank=0;

        for(int i=0;i<6;i++){
            int temp=l.get(i);
            if(w.contains(temp))
                rank++;
        }

        int max=rank+count;

        answer=new int[2];
        answer[0]=m.get(max);
        answer[1]=m.get(rank);

        return answer;
    }
}
