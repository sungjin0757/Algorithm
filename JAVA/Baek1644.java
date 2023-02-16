package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek1644 {
    private int n;
    private boolean[] primeCheck;
    private int answer = 0;
    private List<Integer> primes = new ArrayList<>();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        primeCheck = new boolean[n + 1];

        process();

        System.out.println(answer);
    }

    private void process() {
        makePrime();
        twoPointer();
    }

    private void makePrime() {
        for (int i = 2; i <= n; i++) {
            if(primeCheck[i])
                continue;
            primes.add(i);
            for (int j = i + i; j <= n; j += i) {
                primeCheck[j] = true;
            }
        }
    }

    private void twoPointer() {
        int present = 0;
        int end = 0;
        int temp = 0;

        for (int i = present; i < primes.size(); i++) {
            while (temp < n && end < primes.size()) {
                temp += primes.get(end);
                end++;
            }

            if (temp == n) {
                answer++;
            }
            temp -= primes.get(i);
        }
    }
}
