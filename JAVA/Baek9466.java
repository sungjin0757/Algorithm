package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek9466 {
    private int t;
    private StringBuilder sb = new StringBuilder();
    private int count ;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            process(n, arr);
            sb.append((n - count) + "\n");
        }

        System.out.print(sb.toString());
    }

    private int process(int n, int[] arr) {
        int cnt = 0;
        boolean[] answerCheck = new boolean[n + 1];
        boolean[] pathCheck = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if(answerCheck[i])
                continue;
            dfs(i, answerCheck, pathCheck, arr);

        }

        return cnt;
    }

    private void dfs(int node, boolean[] answerCheck, boolean[] pathCheck, int[] arr) {
        if (pathCheck[node]) {
            return;
        }

        pathCheck[node] = true;

        int next = arr[node];
        if(!pathCheck[next] ) {
            dfs(next, answerCheck, pathCheck, arr);
        } else {
            if(!answerCheck[next]) {
                count++;
                for (int i = next; i != node; i = arr[i]) {
                    count++;
                }
            }
        }

        answerCheck[node] = true;

    }

}
