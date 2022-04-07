package programmers;

public class Lev3_20 {
    class Solution {
        int[][] arr;
        int[] temp;
        int n;
        int res=0;

        private void dfs(int x){
            if(x==n){
                res++;
                return;
            }
            for(int i=0;i<n;i++){
                temp[x]=i;
                if(!possible(x)){
                    continue;
                }
                dfs(x+1);
            }
        }

        private boolean possible(int co){
            for(int i=0;i<co;i++){
                if(temp[i]==temp[co]){
                    return false;
                }
                if(Math.abs(i-co)==Math.abs(temp[i]-temp[co])){
                    return false;
                }
            }
            return true;
        }
        public int solution(int n) {
            this.n=n;
            arr=new int[n][n];
            temp=new int[n];
            dfs(0);
            return res;
        }
    }
}
