package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek13904 {

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n;

        List<int[]> arr=new ArrayList<>();
        n=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            int[] temp={a,b};

            arr.add(temp);
        }

        arr.sort((o1,o2)->{
            if(o1[1]==o2[1])
                return Integer.compare(o1[0],o2[0]);
            return Integer.compare(-o1[1],-o2[1]);
        });

        int score=0;
        int time=0;
        int[] temp=new int[1002];

        for(int i=0;i<n;i++){
            for(int j=arr.get(i)[0];j>0;j--){
                if(temp[j]==0){
                    temp[j]=arr.get(i)[1];
                    break;
                }
            }
        }

        for(int i=1;i<temp.length;i++){
            score+=temp[i];
        }



        System.out.println(score);


    }
}
