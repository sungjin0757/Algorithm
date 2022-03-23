package programmers;
import java.util.*;
public class Lev3_11 {

    class Solution {
        PriorityQueue<Integer> dq=new PriorityQueue<>();
        public String solution(int n, int t, int m, String[] timetable) {
            String answer = "";
            for(String time : timetable){
                dq.offer(makeTime(time));
            }
            int start=9*60;
            int res=9*60;
            for(int i=0;i<n;i++){
                if(i>0)
                    start+=t;
                List<Integer> list=new ArrayList<>();
                while(!dq.isEmpty()){
                    int temp=dq.poll();
                    if(temp>start || list.size()==m){
                        dq.offer(temp);
                        break;
                    }else{
                        list.add(temp);
                    }
                }
                if(list.size()==0 || m>list.size()){
                    System.out.println(start);
                    res=start;
                    continue;
                }
                if(m==list.size()){
                    res=list.get(list.size()-1)-1;
                }
            }
            System.out.println(res);
            return makeRes(res);
        }

        private int makeTime(String time){
            String[] temp=time.split(":");
            return Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
        }

        private String makeRes(int t){
            StringBuilder sb=new StringBuilder();
            int h=t/60;
            int m=t%60;
            if(h<10){
                sb.append("0");
            }
            sb.append(h+":");
            if(m<10){
                sb.append("0");
            }
            sb.append(m);
            return sb.toString();
        }
    }
}
