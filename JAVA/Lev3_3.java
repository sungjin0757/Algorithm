package programmers;
import java.util.*;

public class Lev3_3 {
    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);
            long min=0;
            long max=(long)n*times[times.length-1];

            while(min<=max){
                long mid=(min+max)/2;
                long sum=0;
                for(int i=0;i<times.length;i++){
                    sum+=mid/times[i];
                }
                if(sum<n){
                    min=mid+1;
                }else{
                    max=mid-1;
                    answer=mid;
                }
            }
            return answer;
        }
    }
}
