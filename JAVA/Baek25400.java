package koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek25400 {
    private int n;
    private int[] arr;
    private int answer = 0;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        process();

        System.out.println(answer);
    }

    private void process() {
        int checkNum = 1;
        for(int i = 0 ; i < n; i++) {
            if(arr[i] == checkNum) {
                checkNum++;
                continue;
            }
            answer++;
        }
    }
}
