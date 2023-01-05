package programmers;
import java.util.*;
public class Programmers3_4 {

    class Solution {
        private List<Integer>[] map;
        private int n;
        private int[][] lighthouse;
        private boolean[] check;
        private int answer = 0;

        public int solution(int n, int[][] lighthouse) {
            init(n, lighthouse);
            while(!answerCheck()) {
                findLeaf();
            }
            return answer;
        }

        private void init(int n, int[][] lighthouse) {
            map = new ArrayList[n + 1];
            check = new boolean[n + 1];
            for(int i = 0; i <= n; i++) {
                map[i] = new ArrayList<>();
            }

            for(int[] l : lighthouse) {
                map[l[0]].add(l[1]);
                map[l[1]].add(l[0]);
            }
            this.n = n;
            this.lighthouse = lighthouse;
        }

        private void removeLeaf(int parent, int child) {
            map[parent].remove(Integer.valueOf(child));
        }

        private void findLeaf() {
            for(int i = 1; i <= n; i++) {
                if(map[i].size() != 1) {
                    continue;
                }

                int target = map[i].get(0);
                removeLeaf(target, i);
                map[i].clear();

                if(!check[i]) {
                    if(!check[target]) {
                        check[target] = true;
                        answer++;
                    }
                }
            }
        }

        private boolean answerCheck() {
            for(int[] l : lighthouse) {
                if(!check[l[0]] && !check[l[1]])
                    return false;
            }
            return true;
        }

    }
}
