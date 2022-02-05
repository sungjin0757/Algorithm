package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14891 {

    int[][] arr;
    int k;

    private void roc(int x,int flag){
        int temp=0;

        if(flag==1) {
            temp=arr[x][0];
            for (int i = 1; i < 8; i++) {
                int ttemp=arr[x][i];
                arr[x][i]=temp;
                temp=ttemp;
            }
            arr[x][0] = temp;
        }

        if(flag==-1) {
            temp=arr[x][7];
            for (int i = 6; i >= 0; i--) {
                int ttemp=arr[x][i];
                arr[x][i] = temp;
                temp = ttemp;
            }
            arr[x][7] = temp;
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        arr=new int[4][8];

        for(int i=0;i<4;i++){
            String[] temp=br.readLine().split("");
            for(int j=0;j<8;j++){
                arr[i][j]=Integer.parseInt(temp[j]);
            }
        }

        k=Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int num=Integer.parseInt(st.nextToken())-1;
            int dir=Integer.parseInt(st.nextToken());

            boolean[] check=new boolean[3];
            for(int j=0;j<3;j++){
                if(arr[j][2]!=arr[j+1][6])
                    check[j]=true;
            }
            roc(num,dir);
            dir=-dir;
            if(num==0){
                for(int j=0;j<3;j++){
                    if(!check[j])
                        break;
                    roc(j+1,dir);
                    dir=-dir;
                }
            }else if(num==1){
                if(check[0])
                    roc(0,dir);
                for(int j=1;j<3;j++){
                    if(!check[j])
                        break;
                    roc(j+1,dir);
                    dir=-dir;
                }
            }else if(num==2){
                if(check[2])
                    roc(3,dir);
                for(int j=1;j>=0;j--){
                    if(!check[j])
                        break;
                    roc(j,dir);
                    dir=-dir;
                }
            }else if(num==3){
                for(int j=2;j>=0;j--){
                    if(!check[j])
                        break;
                    roc(j,dir);
                    dir=-dir;
                }
            }

        }
        int res=0;
        if(arr[0][0]==1)
            res++;
        if(arr[1][0]==1)
            res+=2;
        if(arr[2][0]==1)
            res+=4;
        if(arr[3][0]==1)
            res+=8;
        System.out.println(res);

    }
}
