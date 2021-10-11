package kakao;
import java.util.*;

public class Ka19_1 {
    public String[] solution(String[] record) {
        String[] answer = {};

        Map<String,String> temp=new HashMap<>();

        List<String> list=new ArrayList<>();

        for(String s: record){
            String[] temp1=s.split(" ");

            if(temp1[0].equals("Enter")){
                list.add(temp1[1]+"님이 들어왔습니다.");
            }
            else if(temp1[0].equals("Leave")){
                list.add(temp1[1]+"님이 나갔습니다.");
                continue;
            }
            temp.put(temp1[1],temp1[2]);
        }

        answer=new String[list.size()];

        int i=0;
        for(String s:list){
            String[] temp1=s.split("님");
            temp1[0]=temp.get(temp1[0]);
            answer[i]=temp1[0]+"님"+temp1[1];
            i++;
        }
        return answer;
    }
}
