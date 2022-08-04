package kakao;

public class Ka17_2 {
    private String[] freinds = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
    private String[] temp = new String[8];
    private boolean[] check = new boolean[8];
    private int res = 0;
    private String[] data;

    private void dfs(int x) {
        if (x == 8) {
            checkPattern();
            return;
        }
        for (int i = 0; i < 8; i++) {
            if(check[i])
                continue;
            check[i] = true;
            temp[x] = freinds[i];
            dfs(x + 1);
            check[i] = false;
        }
    }

    private void checkPattern() {
        boolean flag = true;
        for (String d : data) {
            int pos1 = findIdx(String.valueOf(d.charAt(0)));
            int pos2 = findIdx(String.valueOf(d.charAt(2)));
            char op = d.charAt(3);
            char val = d.charAt(4);

            if (!ops(op, pos1, pos2, Integer.parseInt(String.valueOf(val)))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            res++;
        }
    }

    private boolean ops(char op, int pos1, int pos2, int val) {
        if(op == '='){
            return eq(pos1, pos2, val);
        }else if(op == '>'){
            return more(pos1, pos2, val);
        }
        return less(pos1, pos2, val);
    }

    private boolean eq(int pos1, int pos2, int val) {
        if (Math.abs(pos1 - pos2) == val + 1) {
            return true;
        }
        return false;
    }

    private boolean more(int pos1, int pos2, int val) {
        if (Math.abs(pos1 - pos2) > val + 1) {
            return true;
        }
        return false;
    }

    private boolean less(int pos1, int pos2, int val) {
        if (Math.abs(pos1 - pos2) < val + 1) {
            return true;
        }
        return false;
    }

    private int findIdx(String s) {
        int idx = 0;
        for (int i = 1; i < 8; i++) {
            if(temp[i].equals(s))
                return i;
        }
        return idx;
    }

    public int solution(int n, String[] data) {

        this.data = data;
        dfs(0);
        return res;
    }
}
