package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1789 {
    private long s;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
        System.out.println(process());
    }

    private long process() {
        long sum = 0;
        long i = 1;
        while(sum <= s) {
            sum += i;
            i++;
        }
        return i - 2;
    }
}
