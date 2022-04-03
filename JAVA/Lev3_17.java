package programmers;
import java.util.*;
public class Lev3_17 {

    class Solution {
        Map<String,List<String>> map=new HashMap<>();
        Map<String,boolean[]> check=new HashMap<>();
        List<String> res=new ArrayList<>();
        int n;

        private void dfs(int x,String end,StringBuilder sb){
            if(x==n){
                StringBuilder sb1=new StringBuilder(sb);
                res.add(sb1.append(end).toString());
                return;
            }
            List<String> temp=map.get(end);
            if(temp==null){
                return;
            }
            for(int i=0;i<temp.size();i++){
                if(check.get(end)[i]){
                    continue;
                }
                StringBuilder sb1=new StringBuilder(sb);
                check.get(end)[i]=true;
                dfs(x+1,temp.get(i),sb1.append(end));
                check.get(end)[i]=false;
            }

        }
        public String[] solution(String[][] tickets) {
            for(String[] ticket : tickets){
                String start=ticket[0];
                String end=ticket[1];
                if(!map.containsKey(start)){
                    map.put(start,new ArrayList<>());
                }
                map.get(start).add(end);

            }
            this.n=tickets.length;
            map.forEach((k,v)->check.put(k,new boolean[v.size()]));
            dfs(0,"ICN",new StringBuilder());
            Collections.sort(res);

            String[] answer=new String[n+1];
            int t=0;
            for(int i=0;i<=res.get(0).length()-3;i+=3){
                StringBuilder sb=new StringBuilder();
                for(int j=i;j<i+3;j++){
                    sb.append(res.get(0).charAt(j));
                }
                answer[t]=sb.toString();
                t++;
            }
            return answer;
        }
    }
}
