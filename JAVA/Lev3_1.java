package programmers;
import java.util.*;
public class Lev3_1 {
    class Solution {
        List<double[]> times=new ArrayList<>();

        private double convertTime(String time){
            String[] temp=time.split(":");
            return (Double.parseDouble(temp[0])*60*60) + (Double.parseDouble(temp[1])*60) + Double.parseDouble(temp[2]);
        }

        public int solution(String[] lines) {
            int answer = 0;

            for(String line:lines){
                String[] temp=line.split(" ");
                double start=convertTime(temp[1]);
                double end=start+Double.parseDouble(temp[2].split("s")[0]);
                times.add(new double[]{start,end});
            }

            for(int i=0;i<lines.length;i++){
                double[] temp=times.get(i);
                double start=temp[0];
                double end=temp[1];
                answer=Math.max(answer,Math.max(part(start),part(end)));
            }
            return answer;
        }
        private int part(double x){
            int cnt=0;
            double partEnd=x+1;
            for(int i=0;i<times.size();i++){
                double[] temp=times.get(i);
                if((temp[0]<=x && x<=temp[1]) || (temp[0]<=partEnd && partEnd<=temp[1]))
                    cnt++;
            }
            return cnt;
        }

    }
}
