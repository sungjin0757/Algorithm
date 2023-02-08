package programmers;
import java.util.*;
public class Programmers3_17 {
    class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
            int camera = -30001;
            int answer = 0;
            for(int[] route : routes) {
                if(camera < route[0]) {
                    answer++;
                    camera = route[1];
                }
            }
            return answer;
        }
    }
}
