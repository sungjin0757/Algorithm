package programmers;
import java.util.*;
public class Programmers3_13 {

    class Solution {
        private List<Point> list = new ArrayList<>();
        private int wonhoAllowPoint, wonhoAttitudePoint;
        private int[][] scores;

        public int solution(int[][] scores) {
            init(scores);
            return process();
        }

        private void init(int[][] scores) {
            wonhoAllowPoint = scores[0][0];
            wonhoAttitudePoint = scores[0][1];

            Arrays.sort(scores, (o1, o2) -> {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(-o1[0], -o2[0]);
            });

            this.scores = scores;
        }

        private int process() {
            if(isEnd())
                return -1;
            Collections.sort(list);
            int i = 1;
            for(Point p : list) {
                if(p.allowPoint == wonhoAllowPoint && p.attitudePoint == wonhoAttitudePoint)
                    break;
                i++;
            }
            return i;
        }

        private boolean isEnd() {
            boolean flag = false;
            int maxScore = 0;
            for(int[] score : scores) {
                if(score[1] < maxScore) {
                    if(score[0] == wonhoAllowPoint && score[1] == wonhoAttitudePoint) {
                        flag = true;
                        break;
                    }
                } else {
                    maxScore = Math.max(maxScore, score[1]);
                    list.add(new Point(score[0], score[1]));
                }
            }
            return flag;
        }

        private class Point implements Comparable<Point> {
            int allowPoint;
            int attitudePoint;
            int totalPoint;

            public Point(int allowPoint, int attitudePoint) {
                this.allowPoint = allowPoint;
                this.attitudePoint = attitudePoint;
                this.totalPoint = allowPoint + attitudePoint;
            }

            @Override
            public int compareTo(Point p) {
                return Integer.compare(-totalPoint, -p.totalPoint);
            }
        }
    }
}
