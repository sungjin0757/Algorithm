package programmers;

public class Lev3_9 {
    class Solution {
        boolean[] check;
        public int solution(int n, int[][] computers) {
            int answer = 0;
            check=new boolean[n];
            for(int i=0;i<n;i++){
                if(check[i])
                    continue;
                check[i]=true;
                dfs(computers,i,n);
                answer+=1;
            }

            return answer;
        }

        private void dfs(int[][] c,int x,int n){

            for(int i=0;i<n;i++){
                if(check[i])
                    continue;
                if(c[x][i]==0)
                    continue;
                check[i]=true;
                dfs(c,i,n);
            }
        }
    }
}
