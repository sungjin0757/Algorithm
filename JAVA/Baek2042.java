package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2042 {
    private int n, m, k;
    private long[] arr;
    private long[] tree;
    private StringBuilder sb = new StringBuilder();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        makeTree();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            process(a, b, c);
        }

        System.out.print(sb.toString());
    }

    private void makeTree() {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        int cnt = (int) Math.pow(2, height);
        tree = new long[cnt + 1];
        init(1, n, 1);
    }

    private void process(int a, int b, long c) {
        if(a == 1) {
            processOne(b, c);
        } else if (a == 2) {
            processTwo(b, c);
        }
    }

    private void processOne(int b, long c) {
        long original = arr[b];
        long diff = c - original;

        arr[b] = c;
        update(1, n, 1, b, diff);
    }

    private void processTwo(int b, long c) {
        sb.append(sum(1, n, 1, b, c) + "\n");
    }

    private long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, (node * 2) + 1);
    }

    private long sum(int start, int end, int node, int left, long right) {
        if (left > end || start > right) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, (node * 2) + 1, left, right);
    }

    private void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) {
            return;
        }
        tree[node] += diff;
        if(start == end)
            return;
        int mid = (start + end) / 2;

        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, (node * 2) + 1, index, diff);
    }
}
