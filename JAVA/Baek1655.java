package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek1655 {
    private int n;
    private PriorityQueue<Integer> minPq = new PriorityQueue<>();
    private PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.comparingInt(c -> -c));
    private StringBuilder sb = new StringBuilder();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (minPq.size() == maxPq.size()) {
                maxPq.offer(value);
            } else {
                minPq.offer(value);
            }

            if (!minPq.isEmpty() && !maxPq.isEmpty() && maxPq.peek() > minPq.peek()) {
                int temp = maxPq.poll();
                maxPq.add(minPq.poll());
                minPq.add(temp);
            }

            sb.append(maxPq.peek() + "\n");
        }

        System.out.println(sb.toString());
    }
}
