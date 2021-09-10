package kakao;
import java.util.*;
public class Ka20_1 {

    class Solution {


        public String solution(String p) {
            String answer = "";

            if(p.length()!=0){
                if(check(p)){
                    return p;
                }
                answer=sol(p);
            }

            return answer;
        }

        private String sol(String s){
            StringBuilder u=new StringBuilder();
            StringBuilder v=new StringBuilder();
            String answer="";
            if(s.length()==0)
                return "";
            if(check(s))
                return s;

            int i=2;
            while(true){
                String temp=s.substring(0,i);
                if(checkBalance(temp)){
                    u.append(temp);
                    break;
                }
                i+=2;
            }
            v.append(s.substring(i));
            if(check(u.toString())){
                answer=sol(v.toString());
                return u.append(answer).toString();
            }
            else{
                StringBuilder t=new StringBuilder();
                t.append("(");
                answer=sol(v.toString());
                t.append(answer);
                t.append(")");
                u.deleteCharAt(0);
                u.deleteCharAt(u.length()-1);
                for(int j=0;j<u.length();j++){
                    if(u.charAt(j)==')')
                        u.setCharAt(j,'(');
                    else
                        u.setCharAt(j,')');
                }
                return t.append(u.toString()).toString();
            }

        }


        private boolean check(String s){
            Stack<String> ds=new Stack<>();
            for(int i=0;i<s.length();i++){
                char temp=s.charAt(i);
                if(temp=='('){
                    ds.push("(");
                }
                else{
                    if(ds.isEmpty())
                        return false;
                    ds.pop();
                }
            }
            if(ds.isEmpty())
                return true;
            else
                return false;
        }

        private boolean checkBalance(String s){
            int temp1=0;
            int temp2=0;

            for(int i=0;i<s.length();i++){
                char temp=s.charAt(i);
                if(temp=='(')
                    temp1+=1;
                else
                    temp2+=1;
            }

            if(temp1==temp2)
                return true;
            else
                return false;
        }
    }
}
