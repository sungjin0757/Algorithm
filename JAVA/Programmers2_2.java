package programmers;
import java.util.*;
public class Programmers2_2 {

    class Solution {
        private int[] comb;
        private PriorityQueue<Result> pq = new PriorityQueue<>();
        private int[][] users;
        private int[] emoticons;

        public int[] solution(int[][] users, int[] emoticons) {
            int[] answer = {};
            comb = new int[emoticons.length];
            answer = new int[2];
            this.users = users;
            this.emoticons = emoticons;

            dfs(0, emoticons.length);

            Result result = pq.peek();
            answer[0] = result.cnt;
            answer[1] = result.money;

            return answer;
        }

        private void dfs(int x, int cnt) {
            if(x == cnt) {
                insertResult();
                return;
            }

            for(int i = 10; i <= 40; i += 10) {
                comb[x] = i;
                dfs(x + 1, cnt);
            }
        }

        private void insertResult() {
            Result result = new Result(0, 0);

            int cnt = 0;
            int money = 0;

            for(int i = 0 ; i < users.length; i++) {
                int sum = 0;
                int rate = users[i][0];
                int limit = users[i][1];
                for(int j = 0 ; j < emoticons.length; j++) {
                    int compRate = comb[j];
                    if(compRate < rate)
                        continue;
                    sum += emoticons[j] * ((double)(100 - compRate) / 100);
                }
                if(sum >= limit) {
                    cnt++;
                } else {
                    money += sum;
                }
            }

            result.cnt = cnt;
            result.money = money;
            pq.offer(result);
        }

        private class Result implements Comparable<Result>{
            int cnt;
            int money;

            public Result(int cnt, int money) {
                this.cnt = cnt;
                this.money = money;
            }

            @Override
            public int compareTo(Result o) {
                if(this.cnt == o.cnt)
                    return Integer.compare(-this.money, -o.money);
                return Integer.compare(-this.cnt, -o.cnt);
            }
        }
    }
}
