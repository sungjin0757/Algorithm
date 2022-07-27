package kakao;


public class Ka22_3 {
    private int[] info, res, temp;
    private int n;

    private void dfs(int cnt, int sum) {
        if (cnt == 11) {
            checkWinner();
        }
        for (int i = 0; i <= n - sum; i++) {
            temp[cnt] = i;
            dfs(cnt + 1, sum + i);
        }
    }

    private int[] res() {
        if(checkRes())
            return new int[]{-1};
        return res;
    }

    private boolean checkRes() {
        for (int re : res) {
            if(re != 0)
                return false;
        }
        return true;
    }

    private void checkWinner() {
        if(compareInfo()){
            copyArray();
        }
    }

    private void copyArray() {
        for (int i = 0; i < 11; i++) {
            res[i] = temp[i];
        }
    }

    private boolean compareInfo() {
        int apeach = 0;
        int ryan = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && temp[i] == 0) {
                continue;
            }
            if(info[i] >= temp[i])
                apeach += (10 - i);
            else if(info[i] < temp[i])
                ryan += (10 - i);
        }

        if(apeach >= ryan)
            return false;
        return true;
    }

    public int[] solution(int n, int[] info) {
        this.info = info;
        this.n = n;
        res = new int[11];
        temp = new int[11];

        return res();
    }
}
