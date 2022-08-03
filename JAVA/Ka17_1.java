package kakao;

public class Ka17_1 {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private boolean[][] check;
    private int res = 0;
    private int temp_cnt = 0;
    private int[][] p;
    private int m, n;

    private void dfs(int x, int y) {
        temp_cnt++;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                continue;
            }
            if (check[xx][yy] || p[xx][yy] != p[x][y]) {
                continue;
            }
            check[xx][yy] = true;
            dfs(xx, yy);
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        this.p = picture;
        this.m = m;
        this.n = n;
        check = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(check[i][j] || p[i][j] == 0)
                    continue;
                check[i][j] = true;
                numberOfArea++;
                dfs(i, j);
                res = Math.max(res, temp_cnt);
                temp_cnt = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = res;
        return answer;
    }
}
