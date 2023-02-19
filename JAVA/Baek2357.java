package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek2357 {
    private int n, m;

    public void solve() {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }
}
