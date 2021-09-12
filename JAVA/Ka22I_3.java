package kakao;
import java.util.*;

public class Ka22I_3 {

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        List<Integer> arr=new LinkedList<>();
        Stack<Integer> delList=new Stack<>();

        for(int i=0;i<n;i++)
            arr.add(1);

        for(String temp:cmd){
            String[] temp1=temp.split(" ");
            if(temp1[0].equals("D")){
                k+=Integer.parseInt(temp1[1]);
            }
            else if(temp1[0].equals("U")){
                k-=Integer.parseInt(temp1[1]);
            }
            else if(temp1[0].equals("C")){
                delList.push(arr.remove(k));
                if(k>arr.size()-1)
                    k=arr.size()-1;
            }
            else if(temp1[0].equals("Z")){
                int temp2=delList.pop();
                arr.get(temp2)=1;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int temp=arr.get(i);
            if(temp==1)
                sb.append("O");
            else
                sb.append("X");
        }

        answer=sb.toString();
        return answer;
    }
}
