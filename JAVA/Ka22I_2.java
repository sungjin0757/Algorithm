package kakao;
import java.util.*;

public class Ka22I_2 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        List<Integer> arr=new LinkedList<>();
        Stack<Integer> delList=new Stack<>();

        for(int i=0;i<n;i++)
            arr.add(i);

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
                if(temp2<arr.get(0)){
                    arr.add(0,temp2);
                    k+=1;
                }
                else if(temp2>arr.get(arr.size()-1)){
                    arr.add(temp2);
                }
                else{

                    int start=0;
                    int end=arr.size()-1;
                    while(start+1<end){
                        int idx=(start+end)/2;

                        if(arr.get(idx)>temp2){
                            end=idx;
                        }
                        else{
                            start=idx;
                        }
                    }
                    arr.add(end,temp2);
                    if(end<=k)
                        k++;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(delList.contains(i))
                sb.append("X");
            else
                sb.append("O");
        }

        answer=sb.toString();
        return answer;
    }
}
