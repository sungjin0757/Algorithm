package kakao;
import java.util.*;

public class Ka19_3 {
    List<Integer> key=new ArrayList<>();

    boolean check(int bit){
        for(int k:key){
            if((k&bit)==k)
                return false;
        }
        return true;
    }

    public int solution(String[][] relation) {
        int answer = 0;

        int n=relation.length;
        int limit=relation[0].length;

        for(int i=1;i<(1<<limit);i++){
            if(!check(i))
                continue;
            Set<String> set=new HashSet<>();
            for(int j=0;j<n;j++){
                StringBuilder sb=new StringBuilder();

                for(int k=0;k<limit;k++){
                    if(((1<<k)&i)>0)
                        sb.append(relation[j][k]).append('/');
                }
                if(!set.add(sb.toString()))
                    break;
            }
            if(set.size()==n)
                key.add(i);
        }
        answer=key.size();
        return answer;
    }
}
