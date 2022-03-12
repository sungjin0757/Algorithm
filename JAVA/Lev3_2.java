package programmers;
import java.util.*;
public class Lev3_2 {
    class Solution {
        List<Set<Integer>> list=new ArrayList<>();

        public int solution(int N, int number) {

            for(int i=1;i<=8;i++){
                list.add(new HashSet<>());
                addNum(i,N);
                if(finishCheck(i,number)){
                    return i;
                }
            }

            return -1;
        }
        private int makeNum(int idx,int n){
            int temp=0;
            for(int i=0;i<idx;i++){
                temp+=Math.pow(10,i)*n;
            }
            return temp;
        }

        private void addNum(int idx,int n){
            Set<Integer> temp=list.get(idx-1);
            temp.add(makeNum(idx,n));
            for(int i=1;i<idx;i++){
                Set<Integer> temp1=list.get(i-1);
                Set<Integer> temp2=list.get(idx-i-1);
                for(Integer pre : temp1){
                    for( Integer post : temp2){
                        temp.add(pre-post);
                        temp.add(pre+post);
                        temp.add(pre*post);
                        if(pre!=0 && post!=0)
                            temp.add(pre/post);
                    }
                }
            }
        }

        private boolean finishCheck(int idx,int number){
            if(list.get(idx-1).contains(number))
                return true;
            return false;
        }
    }
}
