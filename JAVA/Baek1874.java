package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek1874 {
    private int n;
    private int[] arr;
    private Stack<Integer> stack = new Stack<>();
    private StringBuilder sb = new StringBuilder();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        process();

        System.out.print(sb.toString());
    }

    private void process() {
        int present = 1;
        for (int i = 1; i <= n; i++) {
            int value = arr[i];

            while (stack.isEmpty() || stack.peek() != value) {
                if (present > n + 1) {
                    sb = new StringBuilder("NO");
                    return;
                }
                sb.append("+\n");
                stack.push(present++);
            }
            stack.pop();
            sb.append("-\n");
        }
    }
}
