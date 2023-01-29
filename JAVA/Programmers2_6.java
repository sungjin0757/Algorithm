package programmers;
import java.util.*;
public class Programmers2_6 {

    class Solution {
        private int[][] map;
        private List<Integer> temp = new ArrayList<>();
        private int[] answer;
        private int[] dx = new int[]{-1, 1, 0, 0};
        private int[] dy = new int[]{0, 0, -1, 1};

        public int[] solution(String[] maps) {
            init(maps);
            process();
            return answer;
        }

        private void init(String[] maps) {
            map = new int[maps.length][maps[0].length()];

            for(int i = 0 ; i < maps.length; i++) {
                String s = maps[i];
                for(int j = 0 ; j < s.length(); j++) {
                    char c = maps[i].charAt(j);
                    if(c == 'X') {
                        map[i][j] = -1;
                        continue;
                    }
                    map[i][j] = c - '0';
                }
            }
        }

        private void process() {
            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[i].length; j++) {
                    if(map[i][j] != -1) {
                        temp.add(bfs(i, j));
                    }
                }
            }
            getResult();
        }

        private int bfs(int row, int col) {
            int sum = 0;
            Queue<int[]> dq = new LinkedList<>();
            dq.offer(new int[]{row, col});
            sum += map[row][col];
            map[row][col] = -1;

            while(!dq.isEmpty()) {
                int[] arr = dq.poll();
                int pollRow = arr[0];
                int pollCol = arr[1];

                for(int i = 0 ; i < 4; i++) {
                    int xx = pollRow + dx[i];
                    int yy = pollCol + dy[i];

                    if(xx < 0 || xx >= map.length || yy <0 || yy >= map[0].length)
                        continue;
                    if(map[xx][yy] == -1)
                        continue;
                    sum += map[xx][yy];
                    map[xx][yy] = -1;
                    dq.offer(new int[]{xx, yy});
                }
            }

            return sum;
        }

        private void getResult() {
            if(temp.size() == 0) {
                answer = new int[1];
                answer[0] = -1;
                return;
            }
            answer = new int[temp.size()];

            Collections.sort(temp);
            for(int i = 0; i < temp.size(); i++) {
                answer[i] = temp.get(i);
            }
        }
    }
}
