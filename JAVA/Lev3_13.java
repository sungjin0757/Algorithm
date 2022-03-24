package programmers;
import java.util.*;
public class Lev3_13 {
    class Solution {
        String[] user,ban;
        int[] temp;
        int[] temp2;
        int res=0;
        List<int[]> list=new ArrayList<>();
        boolean[] check2;

        private void dfs(int x,int y){
            if(x==ban.length){

                for(int i=0;i<list.size();i++){
                    boolean check=true;
                    int[] temp3=list.get(i);
                    for(int j=0;j<temp.length;j++){
                        if(!matchId(user[temp[j]],ban[temp3[j]])){
                            check=false;
                            break;
                        }
                    }
                    if(check){
                        res++;
                        break;
                    }
                }
                return;
            }
            for(int i=y;i<user.length;i++){
                temp[x]=i;
                dfs(x+1,i+1);
            }
        }
        private void dfs2(int x){
            if(x==temp2.length){
                int[] temp3=new int[temp2.length];
                for(int i=0;i<temp2.length;i++){
                    temp3[i]=temp2[i];
                }
                list.add(temp3);
                return;
            }

            for(int i=0;i<ban.length;i++){
                if(check2[i])
                    continue;
                temp2[x]=i;
                check2[i]=true;
                dfs2(x+1);
                check2[i]=false;
            }
        }

        public int solution(String[] user_id, String[] banned_id) {
            int answer = 0;
            this.user=user_id;
            this.ban=banned_id;
            temp=new int[ban.length];
            temp2=new int[ban.length];
            check2=new boolean[ban.length];
            dfs2(0);
            dfs(0,0);
            return res;
        }

        private boolean matchId(String id1,String id2){
            if(id1.length()!=id2.length())
                return false;
            for(int i=0;i<id1.length();i++){
                if(id1.charAt(i)!=id2.charAt(i) && id2.charAt(i)!='*')
                    return false;
            }
            return true;
        }
    }
}
