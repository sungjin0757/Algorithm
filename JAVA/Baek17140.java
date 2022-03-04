package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek17140 {

    int r,c,k;
    int[][] arr;
    PriorityQueue<int[]> dq=new PriorityQueue<>((o1,o2)->{
        if(o1[1]==o2[1])
            return Integer.compare(o1[0],o2[0]);
        return Integer.compare(o1[1],o2[1]);
    });

    private void op(String s){
        boolean[] check=new boolean[101];

        for(int i=1;i<=100;i++){
            Arrays.fill(check,false);
            for(int j=1;j<=100;j++){
                if(dq.size()>=50)
                    break;
                if(s.equals("R")) {
                    if (arr[i][j] == 0)
                        continue;
                }else{
                    if(arr[j][i]==0)
                        continue;
                }
                if(check[j])
                    continue;
                int temp=1;
                check[j]=true;
                for(int k=j+1;k<=100;k++){
                    if(check[k]) {
                        continue;
                    }
                    if(s.equals("R")){
                        if(arr[i][j]==arr[i][k]) {
                            temp++;
                            check[k]=true;
                        }
                    }else{
                        if(arr[j][i]==arr[k][i]){
                            temp++;
                            check[k]=true;
                        }
                    }
                }
                if(s.equals("R"))
                    dq.offer(new int[]{arr[i][j],temp});
                else
                    dq.offer(new int[]{arr[j][i],temp});
            }
            int t=1;
            while(!dq.isEmpty()){
                int[] temp=dq.poll();
                if(s.equals("R")) {
                    arr[i][t] = temp[0];
                    arr[i][t + 1] = temp[1];
                }else{
                    arr[t][i]=temp[0];
                    arr[t+1][i]=temp[1];
                }
                t+=2;
            }
            for(int j=t;j<=100;j++){
                if(s.equals("R")){
                    arr[i][j]=0;
                }else{
                    arr[j][i]=0;
                }
            }

        }
    }

    private int[] maxRC(){
        int row=0;
        int col=0;

        for(int i=1;i<=100;i++){
            int temp1=0;
            int temp2=0;
            for(int j=1;j<=100;j++){
                if(arr[i][j]==0 && arr[j][i]==0)
                    break;
                if(arr[i][j]!=0)
                    temp2++;
                if(arr[j][i]!=0)
                    temp1++;
            }
            row=Math.max(temp1,row);
            col=Math.max(temp2,col);
        }
        return new int[]{row,col};
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[101][101];

        for(int i=1;i<=3;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int res=0;
        while(true){
            if(arr[r][c]==k) {
                break;
            }
            if(res>100){
                System.out.println(-1);
                return;
            }
            int[] temp=maxRC();

            if(temp[0]>=temp[1]){
                op("R");
            }else{
                op("C");
            }
            res++;

        }
        System.out.println(res);

    }
}
