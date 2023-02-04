package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1700 {
    private int n, k;
    private int answer = 0;
    private int[] pattern;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pattern = new int[k];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < k; i++) {
            pattern[i] = Integer.parseInt(st.nextToken());
        }

        process();

        System.out.println(answer);
    }

    private void process() {
        int present = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < k; i++) {
            int p = pattern[i];
            if(present < n) {
                present++;
                list.add(p);
                continue;
            }

            if(list.contains(p)) {
                list.remove(Integer.valueOf(p));
                list.add(Integer.valueOf(p));
            } else {
                noPlug(i, list);
                answer++;
            }
        }
    }

    private void noPlug(int start, List<Integer> list) {
        boolean check = Arrays.stream(pattern, start + 1, k).anyMatch(pp -> list.contains(pp));

        if(check) {
            for(int i = k - 1; i > start; i--) {
                if(list.contains(i)) {
                    list.remove(Integer.valueOf(i));
                    list.add(Integer.valueOf(pattern[start]));
                    break;
                }
            }
        } else {
            list.remove(0);
            list.add(Integer.valueOf(pattern[start]));
        }
    }
}
