package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2629 {

    int n1,n2;
    int[] arr1;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n1=Integer.parseInt(br.readLine());
        arr1=new int[40001];

        List<Integer> arr3=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n1;i++){
            int temp=Integer.parseInt(st.nextToken());
            int temp1=arr3.stream().mapToInt(Integer::intValue).sum();
            arr3.add(temp);

            List<Integer> arr4=new ArrayList<>();
            for(int j=0;j<=temp1;j++){
                if(arr1[j]==1){
                    if(temp-j>=0){
                        if(arr1[temp-j]!=1)
                            arr4.add(temp-j);
                    }
                    if(arr1[temp+j]!=1)
                        arr4.add(temp+j);
                }
            }

            arr1[temp]=1;


            for (Integer integer : arr4) {
                arr1[integer]=1;
            }

            for(int j=0;j<=10;j++){
                System.out.println(arr1[j]);
            }
            System.out.println();
        }


        n2=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n2;i++){
            int temp=Integer.parseInt(st.nextToken());

            if(arr1[temp]==1){
                sb.append("Y ");
            }
            else
                sb.append("N ");
        }

        System.out.println(sb);
    }
}
