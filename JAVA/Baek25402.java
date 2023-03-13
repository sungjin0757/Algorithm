package koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek25402 {
    private int n, q;
    private List<int[]> edges = new ArrayList<>();
    private List<Integer> answer = new ArrayList<>();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            edges.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        q= Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int[] kArr = new int[k];
            for (int j = 0; j < k; j++) {
                kArr[j] = Integer.parseInt(st.nextToken());
            }

            process(k, kArr);
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private void process(int k, int[] kArr) {
        int[] arr = new int[n + 1];
        init(arr);

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if(!isInK(from, kArr) || !isInK(to, kArr))
                continue;

            int fromParent = getParent(arr, from);
            int toParent = getParent(arr ,to);

            if(fromParent == toParent)
                continue;
            arr[fromParent] = toParent;
        }
        getAnswer(arr, kArr);
    }

    private void init(int[] arr) {
        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }
    }

    private boolean isInK(int edge, int[] kArr) {
        return Arrays.stream(kArr).anyMatch(k -> k == edge);
    }

    private int getParent(int[] arr, int node) {
        if(arr[node] == node)
            return node;
        return arr[node] = getParent(arr, arr[node]);
    }

    private void getAnswer(int[] arr, int[] kArr) {
        int cnt = 0;
        for(int i = 0; i < kArr.length; i++) {
            for (int j = i + 1; j < kArr.length; j++) {
                int node1 = getParent(arr, kArr[i]);
                int node2 = getParent(arr, kArr[j]);

                if (node1 == node2) {
                    cnt++;
                }
            }
        }
        answer.add(cnt);
    }
}
