package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17144 {

    int r,c,t;
    int[][] arr;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int[] cleanIdx=new int[2];

    private void expand(){
        List<int[]> t=new ArrayList<>();

        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(arr[i][j]==0)
                    continue;
                int size=arr[i][j]/5;
                if(size==0)
                    continue;
                int cnt=0;
                for(int k=0;k<4;k++){
                    int xx=i+dx[k];
                    int yy=j+dy[k];
                    if( (yy==1 && (xx==cleanIdx[0] || xx==cleanIdx[1]))){
                        continue;
                    }
                    if(0<xx && xx<=r && 0<yy && yy<=c){
                        cnt++;
                        t.add(new int[]{xx,yy,size});
                    }
                }
                arr[i][j]-=(cnt*size);
            }
        }

        for(int i=0;i<t.size();i++){
            int[] temp=t.get(i);
            arr[temp[0]][temp[1]]+=temp[2];
        }
    }

    private int swap(int row,int col,int temp){
        int ttemp=arr[row][col];
        arr[row][col]=temp;
        return ttemp;
    }

    private void clean(){
        int r1=cleanIdx[0];
        int r2=cleanIdx[1];

        int temp=0;
        for(int i=2;i<=c;i++){
            temp=swap(r1,i,temp);
        }
        for(int i=r1-1;i>=1;i--){
            temp=swap(i,c,temp);
        }
        for(int i=c-1;i>=1;i--){
            temp=swap(1,i,temp);
        }
        for(int i=2;i<r1;i++){
            temp=swap(i,1,temp);
        }

        temp=0;
        for(int i=2;i<=c;i++){
            temp=swap(r2,i,temp);
        }
        for(int i=r2+1;i<=r;i++){
            temp=swap(i,c,temp);
        }
        for(int i=c-1;i>=1;i--){
            temp=swap(r,i,temp);
        }
        for(int i=r-1;i>r2;i--){
            temp=swap(i,1,temp);
        }


    }

    private int res(){
        int temp=0;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(arr[i][j]!=0)
                    temp+=arr[i][j];
            }
        }
        return temp;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        arr=new int[r+1][c+1];
        int idx=0;

        for(int i=1;i<=r;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=c;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==-1){
                    cleanIdx[idx]=i;
                    arr[i][j]=0;
                    idx++;
                }
            }
        }

        for(int i=0;i<t;i++){
            expand();
            clean();
        }
        System.out.println(res());
    }
}
