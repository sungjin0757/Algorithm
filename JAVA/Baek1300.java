package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1300 {
    private int n, k;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = k;

        while (left < right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                long temp = mid / i > n ? n : mid / i;
                cnt += temp;
            }

            if(cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
