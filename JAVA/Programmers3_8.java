package programmers;
import java.util.*;

public class Programmers3_8 {

    class Solution {
        private PriorityQueue<Result>[] pq;
        private int[] answer;
        private int target;

        public int[] solution(int target) {
            init(target);
            process();
            Result result = pq[target].poll();
            answer[0] = result.bestCnt;
            answer[1] = result.singleOrBoolCnt;

            return answer;
        }

        private void init(int target) {
            pq = new PriorityQueue[target + 1];
            for(int i = 0; i <= target; i++) {
                pq[i] = new PriorityQueue<>();
            }
            answer = new int[2];
            this.target = target;
        }

        private void process() {
            pq[0].offer(new Result(0, 0));
            pq[1].offer(new Result(1, 1));

            for(int i = 2; i <= target; i++) {
                for(int j = 1; j <= 20; j++) {
                    int triple = i - (j * 3);
                    if(triple >= 0) {
                        addValueInPriorityQueue(triple, i, false);
                    }
                    int doub = i - (j * 2);
                    if(doub >= 0) {
                        addValueInPriorityQueue(doub, i, false);
                    }
                    int single = i - j;
                    if(single >= 0) {
                        addValueInPriorityQueue(single, i, true);
                    }
                }
                int bool = i - 50;
                if(bool >= 0) {
                    addValueInPriorityQueue(bool, i, true);
                }
            }
        }

        private void addValueInPriorityQueue(int pastIdx, int postIdx, boolean isSingleOrBool) {
            Result result = pq[pastIdx].peek();
            int bestCnt = result.bestCnt + 1;
            int singleOrBoolCnt = result.singleOrBoolCnt;
            if(isSingleOrBool) {
                singleOrBoolCnt++;
            }
            pq[postIdx].offer(new Result(bestCnt, singleOrBoolCnt));
        }

        private class Result implements Comparable<Result> {
            int bestCnt;
            int singleOrBoolCnt;

            public Result(int bestCnt, int singleOrBoolCnt) {
                this.bestCnt = bestCnt;
                this.singleOrBoolCnt = singleOrBoolCnt;
            }

            @Override
            public int compareTo(Result o2) {
                if(this.bestCnt == o2.bestCnt) {
                    return Integer.compare(-this.singleOrBoolCnt, -o2.singleOrBoolCnt);
                }
                return Integer.compare(this.bestCnt, o2.bestCnt);
            }
        }
    }
}
