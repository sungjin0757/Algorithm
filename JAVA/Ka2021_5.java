package kakao;

import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        String[] temp1=play_time.split(":");
        String[] temp2=adv_time.split(":");

        int ptime=changeTime(Integer.parseInt(temp1[0]),Integer.parseInt(temp1[1]),Integer.parseInt(temp1[2]));
        int atime=changeTime(Integer.parseInt(temp2[0]),Integer.parseInt(temp2[1]),Integer.parseInt(temp2[2]));


        long[] time=new long[ptime+1];
        for(int i=0;i<logs.length;i++){
            String[] temp3=logs[i].split("-");
            String[] temp4=temp3[0].split(":");
            String[] temp5=temp3[1].split(":");

            int start=changeTime(Integer.parseInt(temp4[0]),Integer.parseInt(temp4[1]),Integer.parseInt(temp4[2]));
            int end=changeTime(Integer.parseInt(temp5[0]),Integer.parseInt(temp5[1]),Integer.parseInt(temp5[2]));
            time[start]+=1;
            time[end]-=1;

        }

        for(int i=1;i<=ptime;i++){
            time[i]+=time[i-1];
        }
        for(int i=1;i<=ptime;i++){
            time[i]+=time[i-1];
        }

        long maxp=time[atime-1];
        long maxs=0;

        for(int i=0;i+atime<=ptime;i++){
            long temp=time[i+atime]-time[i];

            if(temp>maxp){
                maxp=temp;
                maxs=i+1;
            }

            answer=changeRes(maxs);

        }
        return answer;
    }

    private int changeTime(int hour,int minute,int second){
        return hour*3600+minute*60+second;
    }

    private String changeRes(long s){
        long t=s/3600;
        long m=(s%3600)/60;
        long e=(s%3600)%60;
        StringBuilder sb=new StringBuilder();
        if(t<10){
            sb.append("0"+String.valueOf(t)+":");
        }
        else{
            sb.append(String.valueOf(t)+":");
        }
        if(m<10){
            sb.append("0"+String.valueOf(m)+":");
        }
        else{
            sb.append(String.valueOf(m)+":");
        }
        if(e<10){
            sb.append("0"+String.valueOf(e));
        }
        else{
            sb.append(String.valueOf(e));
        }
        return sb.toString();
    }


}