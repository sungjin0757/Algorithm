package programmers;

import java.util.*;

public class Dev3 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        Map<String,String> map=new HashMap<>();
        Map<String,Integer> res=new HashMap<>();

        for(int i=0;i<enroll.length;i++){
            map.put(enroll[i],referral[i]);
            res.put(enroll[i],0);
        }

        for(int i=0;i<seller.length;i++){
            String temp=seller[i];
            int mo=amount[i]*100;

            if(!map.get(temp).equals("-"))
            {
                while(!map.get(temp).equals("-")){
                    int temp1=mo;
                    mo=temp1/10;

                    if(mo<1){
                        res.put(temp,res.get(temp)+temp1);
                        break;
                    }
                    res.put(temp,res.get(temp)+temp1-mo);
                    temp=map.get(temp);
                    // res.put(temp,res.get(temp)+mo);
                }

            }
            int temp1=mo/10;
            if(temp1<1){
                res.put(temp,res.get(temp)+mo);
            }
            else{
                res.put(temp,res.get(temp)+mo-temp1);
            }

        }

        answer=new int[enroll.length];

        for(int i=0;i<enroll.length;i++){
            answer[i]=res.get(enroll[i]);
        }
        return answer;
    }
}
