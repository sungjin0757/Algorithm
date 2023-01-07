package programmers;

public class Programmers3_5 {
    class Solution {
        private int answer = Integer.MAX_VALUE;
        private int[][] beginning, target;
        private int row, col;

        public int solution(int[][] beginning, int[][] target) {
            init(beginning, target);
            process();
            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        private void init(int[][] beginning, int[][] target) {
            this.beginning = beginning;
            this.target = target;
            this.row = beginning.length;
            this.col = beginning[0].length;
        }

        private void process() {
            for(int i = 0; i < (1 << row); i++) {
                int tempSum = 0;
                int[][] copyBeginning = new int[row][col];
                copyArray(copyBeginning);
                tempSum += flipBitRow(copyBeginning, i);
                tempSum += flipColCompareTarget(copyBeginning);
                if(compareAnswer(copyBeginning)) {
                    answer = Math.min(tempSum, answer);
                }
            }
        }

        private void copyArray(int[][] copy) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j< col; j++) {
                    copy[i][j] = beginning[i][j];
                }
            }
        }

        private int flipBitRow(int[][] copyBeginning, int unit) {
            int cnt = 0;
            for(int i = 0; i < row; i++) {
                int comp = (1 << i);
                if((unit & comp) == comp) {
                    flipRow(copyBeginning, i);
                    cnt++;
                }
            }
            return cnt;
        }

        private int flipColCompareTarget(int[][] copyBeginning) {
            int cnt = 0;
            for(int i = 0; i < col; i++) {
                if(!compareCol(copyBeginning, i)) {
                    flipCol(copyBeginning, i);
                    cnt++;
                } else {
                }
            }
            return cnt;
        }

        private boolean compareCol(int[][] copyBeginning, int colNum) {
            for(int i = 0; i < row; i++) {
                if(copyBeginning[i][colNum] != target[i][colNum])
                    return false;
            }
            return true;
        }

        private boolean compareAnswer(int[][] copyBeginning) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(copyBeginning[i][j] != target[i][j])
                        return false;
                }
            }
            return true;
        }

        private void flipRow(int[][] copyBeginning, int row) {
            for(int i = 0; i < col; i++) {
                if(copyBeginning[row][i] == 1)
                    copyBeginning[row][i] = 0;
                else if(copyBeginning[row][i] == 0)
                    copyBeginning[row][i] = 1;
            }
        }

        private void flipCol(int[][] copyBeginning, int col) {
            for(int i = 0; i < row; i++) {
                if(copyBeginning[i][col] == 1)
                    copyBeginning[i][col] = 0;
                else if(copyBeginning[i][col] == 0)
                    copyBeginning[i][col] = 1;
            }
        }

    }
}
