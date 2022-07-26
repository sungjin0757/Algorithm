package kakao;

import java.util.ArrayList;
import java.util.List;

public class Ka22_2 {
    private int[] info;
    private boolean[][] check;
    private List<Integer>[] dest;
    private int res = Integer.MIN_VALUE;

    private void dfs(int sheep, int wolf, int node, boolean[] numCheck) {
        boolean[] c = numCheck.clone();
        if(info[node] == 0){
            sheep = addAnimal(node, sheep, c);
        } else if (info[node] == 1) {
            wolf = addAnimal(node, wolf, c);
        }
        if(wolf >= sheep)
            return;
        res = Math.max(res, sheep);
        for (int d : dest[node]) {
            if(check[node][d])
                continue;
            check[node][d] = true;
            dfs(sheep, wolf, d, c);
            check[node][d] = false;
        }

    }

    private int addAnimal(int node, int cnt, boolean[] numCheck) {
        if(!numCheck[node]){
            numCheck[node] = true;
            cnt += 1;
        }
        return cnt;
    }


    public int solution(int[] info, int[][] edges) {
        this.info = info;
        check = new boolean[info.length][info.length];
        dest = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            dest[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            dest[e[0]].add(e[1]);
            dest[e[1]].add(e[0]);
        }

        dfs(0, 0, 0, new boolean[info.length]);
        return res;
    }

}
