package programmers;
import java.util.*;
public class Programmers3_16 {
    class Solution {
        private boolean answer = false;
        private int[][] testKey;

        public boolean solution(int[][] key, int[][] lock) {
            testKey = new int[lock.length * 3][lock.length * 3];
            process(key, lock);
            return answer;
        }

        private void process(int[][] key, int[][] lock) {
            int n = lock.length;
            for(int i = 1; i < n * 2; i++) {
                for(int j = 1; j < n * 2; j++) {
                    if(answer)
                        return;
                    checkRotatedKey(i, j, key, lock);
                }
            }
        }

        private void checkRotatedKey(int startRow, int startCol, int[][] key, int[][] lock) {
            for(int i = 1; i <= 4; i++) {
                if(answer)
                    return;
                int[][] newKey = rotateKey(key, i);
                testKeyInit();
                copyKey(newKey, startRow, startCol);
                answerCheck(lock, startRow, startCol);
            }
        }

        private void testKeyInit() {
            Arrays.stream(testKey).forEach(t -> Arrays.fill(t, 0));
        }

        private void copyKey(int[][] rotatedKey, int startRow, int startCol) {
            for(int i = 0 ; i < rotatedKey.length; i++) {
                for(int j = 0 ; j < rotatedKey.length; j++) {
                    testKey[i + startRow][j + startCol] = rotatedKey[i][j];
                }
            }
        }

        private void answerCheck(int[][] lock, int startRow, int startCol) {
            for(int i = lock.length; i < lock.length * 2; i++) {
                for(int j = lock.length ; j < lock.length * 2; j++) {
                    if((lock[i - lock.length][j - lock.length] == 1) && (testKey[i][j] == 1)) {
                        return;
                    }
                    if((lock[i - lock.length][j - lock.length] == 0) && (testKey[i][j] == 0)) {
                        return;
                    }
                }
            }
            answer = true;
        }

        private int[][] rotateKey(int[][] key, int degree) {
            int[][] newKey = new int[key.length][key.length];

            for(int i = 0; i < key.length; i++) {
                for(int j = 0 ; j < key[i].length; j++) {
                    rotate(key, newKey, i, j, key.length, degree);
                }
            }

            return newKey;
        }

        private void rotate(int[][] oldKey, int[][] newKey, int row, int col, int size, int degree) {
            if(degree == 1) {
                newKey[col][size - row -1] = oldKey[row][col];
            } else if(degree == 2) {
                newKey[size - row - 1][size - col - 1] = oldKey[row][col];
            } else if(degree == 3) {
                newKey[size - col - 1][row] = oldKey[row][col];
            } else if(degree == 4) {
                newKey[row][col] = oldKey[row][col];
            }
        }
    }
}
