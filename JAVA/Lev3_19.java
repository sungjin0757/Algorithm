package programmers;

public class Lev3_19 {
    class Solution {
        String[] w;
        boolean[] check;
        int res=Integer.MAX_VALUE;
        String t;

        private void dfs(int x,String temp){
            if(x==w.length){
                return;
            }
            if(x>res){
                return;
            }
            if(temp.equals(t)){
                res=Math.min(res,x);
                return;
            }
            for(int i=0;i<w.length;i++){
                if(check[i]){
                    continue;
                }
                if(!matchStr(temp,w[i])){
                    continue;
                }
                check[i]=true;
                dfs(x+1,w[i]);
                check[i]=false;
            }
        }

        private boolean matchStr(String str1,String str2){
            int cnt=0;
            for(int i=0;i<str1.length();i++){
                if(str1.charAt(i)==str2.charAt(i)){
                    cnt++;
                }
            }
            if(str1.length()-1==cnt)
                return true;
            return false;
        }
        public int solution(String begin, String target, String[] words) {
            this.w=words;
            this.t=target;
            check=new boolean[w.length];
            dfs(0,begin);
            if(res==Integer.MAX_VALUE)
                return 0;
            return res;
        }
    }
}
