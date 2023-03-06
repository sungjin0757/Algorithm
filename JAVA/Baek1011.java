package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baek1011 {
    private int t;

    public void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            int dis = y - x;
            int max = (int) Math.sqrt(dis);

            if (max == Math.sqrt(dis)) {
                System.out.println(2 * max -1);
            } else if (dis <= max * max + max) {
                System.out.println(max * 2);
            } else {
                System.out.println(max * 2 + 1);
            }
        }
    }
}
