package kakao;

public class Ka19_4 {
    private int res = Integer.MIN_VALUE;
    private int k;

    private void dfs(int idx, int[] temp, int cnt) {
        if (idx >= temp.length  - 1) {
            res = Math.max(res, cnt + 1);
            dfs(0, temp, cnt + 1);
            return;
        }

        if (temp[idx + 1] > 0) {
            temp[idx + 1]++;
            dfs(idx + 1, temp, cnt);
            temp[idx + 1]--;
            return;
        }

        for (int i = idx + 1; i <= idx + k && i < temp.length; i++) {
            if(temp[i] <= 0)
                continue;
            temp[i]--;
            dfs(i + 1, temp, cnt);
            temp[i]++;
        }
    }

    public int solution(int[] stones, int k) {
        this.k = k;

        dfs(0, stones, 0);
        return res;
    }
}
