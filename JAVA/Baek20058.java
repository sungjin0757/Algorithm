package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek20058 {
    int n,q;
    int[][] arr;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    boolean[][] check;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());

        n=(int )Math.pow(2,n);
        arr=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<q;i++){
            stage1(Integer.parseInt(st.nextToken()));
            stage2();
        }

        System.out.println(res1());
        System.out.println(res2());
    }

    private void stage1(int l){
        int size = (int) Math.pow(2, l);
        for(int row=0;row<n;row+= size){
            for(int col=0;col<n;col+=size){
                int rowStart=row;
                int rowEnd=row+size;
                int colStart=col;
                int colEnd=col+size;
                for(int i=size;i>0;i-=2){
                    for(int j=0;j<i-1;j++){
                        rotate(rowStart,rowEnd,colStart,colEnd);
                    }
                    rowStart++;
                    rowEnd--;
                    colStart++;
                    colEnd--;
                }
            }
        }
    }

    private void stage2(){
        List<int[]> idx=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cnt=0;
                for(int k=0;k<4;k++){
                    int xx=i+dx[k];
                    int yy=j+dy[k];
                    if(xx<0 || xx>=n || yy<0 || yy>=n){
                        continue;
                    }
                    if(arr[xx][yy]>0){
                        cnt++;
                    }
                }
                if(cnt<3){
                    idx.add(new int[]{i,j});
                }
            }
        }

        for(int i=0;i<idx.size();i++){
            int[] d = idx.get(i);
            arr[d[0]][d[1]]--;
        }
    }

    private void rotate(int rowStart,int rowEnd,int colStart,int colEnd){
        int temp=arr[rowStart+1][colStart];
        for(int i=colStart;i<colEnd;i++){
            int ttemp=arr[rowStart][i];
            arr[rowStart][i]=temp;
            temp=ttemp;
        }

        for(int i=rowStart+1;i<rowEnd;i++){
            int ttemp=arr[i][colEnd-1];
            arr[i][colEnd-1]=temp;
            temp=ttemp;
        }

        for(int i=colEnd-2;i>=colStart;i--){
            int ttemp=arr[rowEnd-1][i];
            arr[rowEnd-1][i]=temp;
            temp=ttemp;
        }

        for(int i=rowEnd-2;i>rowStart;i--){
            int ttemp=arr[i][colStart];
            arr[i][colStart]=temp;
            temp=ttemp;
        }
    }

    private int res1(){
        int ice=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]<=0){
                    continue;
                }
                ice+=arr[i][j];
            }
        }
        return ice;
    }

    private int res2(){
        int chunk=0;
        check=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j] || arr[i][j]<=0)
                    continue;
                check[i][j]=true;
                chunk=Math.max(chunk,bfs(i,j));
            }
        }

        return chunk;
    }

    private int bfs(int x,int y){
        Queue<int[]> dq=new LinkedList<>();
        dq.offer(new int[]{x,y});
        int chunk=1;

        while(!dq.isEmpty()){
            int[] idx=dq.poll();
            int sx=idx[0];
            int sy=idx[1];
            for(int i=0;i<4;i++){
                int xx=sx+dx[i];
                int yy=sy+dy[i];
                if(xx<0 || xx>=n || yy<0 || yy>=n){
                    continue;
                }
                if(check[xx][yy] || arr[xx][yy]<=0)
                    continue;
                chunk++;
                check[xx][yy]=true;
                dq.offer(new int[]{xx,yy});
            }
        }
        return chunk;
    }
}
