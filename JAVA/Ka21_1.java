package kakao;

public class Ka21_1 {public String solution(String new_id) {
    String answer = "";

    new_id=new_id.toLowerCase();

    for(int i=0;i<new_id.length();i++){
        char temp=new_id.charAt(i);
        if(temp=='.' ||temp=='-' || temp=='_' || Character.isDigit(temp) || Character.isLowerCase(temp))
        {
            if(answer.length()>0){
                if(temp=='.' && answer.charAt(answer.length()-1)=='.')
                    continue;
            }
            answer+=temp;
        }
    }

    if(answer.startsWith("."))
        answer=answer.substring(1,answer.length());
    if(answer.endsWith("."))
        answer=answer.substring(0,answer.length()-1);
    if(answer.equals(""))
        answer+="aaa";
    if(answer.length()>15)
    {
        answer=answer.substring(0,15);
        if(answer.endsWith("."))
            answer=answer.substring(0,answer.length()-1);
    }
    if(answer.length()<3)
    {
        char temp=answer.charAt(answer.length()-1);
        while(answer.length()<3){
            answer+=temp;
        }

    }


    return answer;
}
}
