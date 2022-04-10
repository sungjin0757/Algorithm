package programmers;

public class Lev3_22 {
    class Solution {
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long answer = -1;
            long r=(long)(1e9*2*1e5*2);
            long l=0;
            while(l<=r){
                long mid=(l+r)/2;
                int gold=0;
                int silver=0;
                int goldSilver=0;
                for(int i=0;i<s.length;i++){
                    long cnt=(long)Math.ceil((double)(mid/t[i])/2);
                    // if((mid%(t[i]*2))>=t[i]){
                    //     cnt++;
                    // }
                    long temp=w[i]*cnt;
                    gold+=Math.min(temp,g[i]);
                    silver+=Math.min(temp,s[i]);
                    goldSilver+=Math.min(temp,g[i]+s[i]);
                }
                if(a<=gold && b<=silver && a+b<=goldSilver){
                    r=mid-1;
                    answer=mid;
                }else{
                    l=mid+1;
                }
            }
            return answer;
        }
    }
}
