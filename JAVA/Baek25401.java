package koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Baek25401 {
    private int n;
    private int[] arr;
    private int answer;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = n - 1;

        process();
        System.out.println(answer);
    }

    private void process() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = Math.max(arr[j] - arr[i], arr[i] - arr[j]);
                int k = j - i;

                if(temp % k > 0)
                    continue;

                int d = (arr[j] - arr[i]) / k;

                int cnt = 0;
                for (int t = 0; t < n; t++) {
                    int cur = arr[i] + (t - i) *d;
                    if(cur == arr[t])
                        cnt++;
                }

                answer = Math.min(answer, n - cnt);
            }
        }
    }
}
