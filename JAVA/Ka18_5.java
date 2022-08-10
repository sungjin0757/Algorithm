package kakao;

public class Ka18_5 {
    private int m, n;
    private char[][] board;
    private int[][] dx = new int[][]{
            {0, 0, -1, -1},
            {0, -1, -1, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
    };
    private int[][] dy = new int[][]{
            {0, -1, 0, -1},
            {0, 0, 1, 1},
            {0, -1, 0, -1},
            {0, 1, 0, 1}
    };
    private int res = 0;
    private boolean[][] finishCheckMap;

    private void playGame() {
        while (true) {
            initFinishCheckMap();
            checkMap();
            addPoint();

            if (isFinish()) {
                break;
            }
            occurGravity();
        }
    }

    private void checkMap() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                checkPoint(i, j);
            }
        }
    }

    private void checkPoint(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int dRow1 = row + dx[i][0];
            int dCol1 = col + dy[i][0];
            if(isIdxOut(dRow1, dCol1))
                continue;
            char data1 = board[dRow1][dCol1];

            int dRow2 = row + dx[i][1];
            int dCol2 = col + dy[i][1];
            if(isIdxOut(dRow2, dCol2))
                continue;
            char data2 = board[dRow2][dCol2];

            int dRow3 = row + dx[i][2];
            int dCol3 = col + dy[i][2];
            if(isIdxOut(dRow3, dCol3))
                continue;
            char data3 = board[dRow3][dCol3];

            int dRow4 = row + dx[i][3];
            int dCol4 = col + dy[i][3];
            if(isIdxOut(dRow4, dCol4))
                continue;
            char data4 = board[dRow4][dCol4];

            if (data1 == data2 && data1 == data3 && data1 == data4 && data1 != '-') {
                finishCheckMap[dRow1][dCol1] = true;
                finishCheckMap[dRow2][dCol2] = true;
                finishCheckMap[dRow3][dCol3] = true;
                finishCheckMap[dRow4][dCol4] = true;
            }
        }
    }

    private boolean isIdxOut(int row, int col) {
        if(row < 0 || row >=m || col <0 || col >= n)
            return true;
        return false;
    }


    private void occurGravity() {
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                placeData(i, j);
            }
        }
    }

    private boolean isEmptyBoard(int row, int col) {
        if(board[row][col] == '-')
            return true;
        return false;
    }

    private void placeData(int row, int col) {
        if(isEmptyBoard(row, col))
            return;
        int emptyIdx = findEmptyIdx(row, col);
        if(emptyIdx == -1)
            return;
        char temp = board[row][col];
        board[row][col] = board[emptyIdx][col];
        board[emptyIdx][col] = temp;
    }

    private int findEmptyIdx(int row, int col) {
        for (int i = m - 1; i > row; i--) {
            if(board[i][col] == '-')
                return i;
        }
        return -1;
    }

    private void addPoint() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (finishCheckMap[i][j]) {
                    res++;
                    board[i][j] = '-';
                }
            }
        }
    }

    private boolean isFinish() {
        for (boolean[] map : finishCheckMap) {
            for (boolean check : map) {
                if(check)
                    return false;
            }
        }
        return true;
    }

    private void initFinishCheckMap() {
        finishCheckMap = new boolean[m][n];
    }

    private void initStringBoardToCharBoard(String[] stringBoard) {
        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = stringBoard[i].charAt(j);
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        initStringBoardToCharBoard(board);
        playGame();
        return res;
    }
}
