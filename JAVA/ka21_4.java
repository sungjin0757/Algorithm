package kakao;
import java.util.*;
public class ka21_4 {

    class Solution {
        public int[] solution(String[] info, String[] query) {
            int[] answer = {};

            StringTokenizer st;
            answer=new int[query.length];

            for(int i=0;i<info.length;i++){
                st=new StringTokenizer(info[i]," ");
                String[] arr=new String[4];
                for(int j=0;j<5;j++){
                    if(j==4)
                    {
                        int point=Integer.parseInt(st.nextToken());
                        for(int k=0;k<query.length;k++){
                            String[] q=query[k].split(" ");
                            if(point>=Integer.parseInt(q[7])){
                                if((q[0].equals("-") || q[0].equals(arr[0])) && (q[2].equals("-") || q[2].equals(arr[1])) && (q[4].equals("-") || q[4].equals(arr[2])) && (q[6].equals("-") || q[6].equals(arr[3]))){
                                    answer[k]+=1;
                                }
                            }
                            else
                                continue;
                        }

                    }
                    else
                        arr[j]=st.nextToken();
                }
            }



            return answer;
        }
    }
}
