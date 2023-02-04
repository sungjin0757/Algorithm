package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek11000 {
    private int n;
    private PriorityQueue<Lesson> pq = new PriorityQueue<>();

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pq.offer(new Lesson(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(process());
    }

    private int process() {
        int cnt = 0;
        int present = -1;

        while (!pq.isEmpty()) {
            Lesson lesson = pq.poll();
            int start = lesson.start;
            int end = lesson.end;

            if(start < present)
                continue;

            present = end;
            cnt++;
        }

        return cnt;
    }

    class Lesson implements Comparable<Lesson> {
        int start;
        int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lesson o) {
            if(end == o.end)
                return Integer.compare(start, o.start);
            return Integer.compare(end, o.end);
        }
    }
}
