package programmers;

public class Programmers2_1 {
    class Solution {

        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;

            int delivery = n - 1;
            int pickup = n - 1;

            while(delivery >= 0 || pickup >= 0) {
                while(delivery >= 0 && deliveries[delivery] == 0) {
                    delivery--;
                }
                while(pickup >= 0 && pickups[pickup] == 0) {
                    pickup--;
                }

                answer += ((Math.max(delivery, pickup) + 1) * 2);

                int sum = 0;
                while(sum < cap && delivery >= 0) {
                    sum += deliveries[delivery];
                    deliveries[delivery--] = 0;
                }

                if(sum > cap) {
                    deliveries[++delivery] = sum - cap;
                }

                sum = 0;
                while(sum < cap && pickup >= 0) {
                    sum += pickups[pickup];
                    pickups[pickup--] = 0;
                }
                if(sum > cap) {
                    pickups[++pickup] = sum - cap;
                }
            }
            return answer;
        }

    }
}
