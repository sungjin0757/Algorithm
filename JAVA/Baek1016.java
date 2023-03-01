package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1016 {
    private long min, max;
    private long answer = 0;
    private boolean[] check;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        check = new boolean[(int) (max - min + 1)];

        process();

        System.out.println(answer);
    }

    private void process() {
        checkAnswer();
        getAnswer();
    }

    private void checkAnswer() {
        for (long i = 2; i <= (long) Math.sqrt(max); i++) {
            long temp = i * i;
            long start = min / temp + (min % temp == 0 ? 0 : 1);
            for (long j = start; j * temp<= max; j++) {
                check[(int)((j * temp) - min)] = true;
            }
        }
    }

    private void getAnswer() {
        for(int i = 0 ; i < check.length; i++) {
            if(!check[i])
                answer++;
        }
    }
}
