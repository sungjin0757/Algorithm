package programmers;

public class Programmers3_14 {
    class Solution {
        private int[][] board;
        private int[] dx = new int[]{-1, 1, 0, 0};
        private int[] dy = new int[]{0, 0, -1, 1};
        private int answer = Integer.MAX_VALUE;

        public int solution(int[][] board, int[] aloc, int[] bloc) {
            this.board = board;
            process(aloc, bloc);
            return answer;
        }

        private void process(int[] aloc, int[] bloc) {
            if(isSameLocation(aloc[0], aloc[1], bloc[0], bloc[1])) {
                answer = 0;
                return;
            }
            aFunc(aloc[0], aloc[1], bloc[0], bloc[1], 0);
        }

        private void aFunc(int aRow, int aCol, int bRow, int bCol, int cnt) {
            // System.out.println(aRow + " " + aCol + " " + bRow + " " + bCol + " " + board[aRow][aCol]+ " "+ board[bRow][bCol]);
            if(cnt >= answer) {
                return;
            }
            if(isSameLocation(aRow, aCol, bRow, bCol)) {
                answer = Math.min(cnt + 1, answer);
                return;
            }
            if(isFinish(aRow, aCol)) {
                answer = Math.min(cnt, answer);
                return;
            }

            for(int i = 0 ; i < 4; i++) {
                int xx = aRow + dx[i];
                int yy = aCol + dy[i];

                if(!isInBoard(xx, yy))
                    continue;
                if(isNoFoot(xx, yy))
                    continue;
                board[xx][yy] -=1;
                bFunc(xx, yy, bRow, bCol, cnt + 1);
                board[xx][yy] += 1;
            }
        }

        private void bFunc(int aRow, int aCol, int bRow, int bCol, int cnt) {
            // System.out.println(aRow + " " + aCol + " " + bRow + " " + bCol + " " + board[aRow][aCol]+ " "+ board[bRow][bCol]);
            if(cnt >= answer) {
                return;
            }
            if(isSameLocation(aRow, aCol, bRow, bCol)) {
                answer = Math.min(cnt + 1, answer);
                return;
            }
            if(isFinish(bRow, bCol)) {
                answer = Math.min(cnt, answer);
                return;
            }

            for(int i = 0 ; i < 4; i++) {
                int xx = bRow + dx[i];
                int yy = bCol + dy[i];

                if(!isInBoard(xx, yy))
                    continue;
                if(isNoFoot(xx, yy))
                    continue;
                board[xx][yy] -=1;
                aFunc(aRow, aCol, xx, yy, cnt + 1);
                board[xx][yy] += 1;
            }
        }

        private boolean isSameLocation(int aRow, int aCol, int bRow, int bCol) {
            if((aRow == bRow) && (aCol == bCol))
                return true;
            return false;
        }

        private boolean isFinish(int row, int col) {
            boolean flag = true;
            for(int i = 0 ; i < 4; i++) {
                int xx = row + dx[i];
                int yy = col + dy[i];
                if(!isInBoard(xx, yy))
                    continue;
                if(isNoFoot(xx, yy))
                    continue;
                flag = false;
                break;
            }

            return flag;
        }

        private boolean isInBoard(int row, int col) {
            if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
                return false;
            return true;
        }

        private boolean isNoFoot(int row, int col) {
            if(board[row][col] <= 0)
                return true;
            return false;
        }
    }
}
