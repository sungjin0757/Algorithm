package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10868 {
    private int n, m;
    private int[] arr;
    private StringBuilder sb = new StringBuilder();
    private int[] tree;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeTree();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getAnswer(1, n, 1, a, b) + "\n");
        }

        System.out.println(sb.toString());
    }

    private void makeTree() {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        int cnt = (int) Math.pow(2, h);
        tree = new int[cnt + 1];
        init(1, n, 1);
    }

    private int init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start - 1];
        }

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, 2 * node), init(mid + 1, end, (2 * node) + 1));
    }

    private int getAnswer(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(getAnswer(start, mid, 2 * node, left, right),
                getAnswer(mid + 1, end, (2 * node) + 1, left, right));
    }
}
