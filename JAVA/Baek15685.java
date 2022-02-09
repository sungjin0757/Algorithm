package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek15685 {
    int n;
    int[][] arr;
    List<Integer> dir;
    int[] dx=new int[]{0,-1,0,1};
    int[] dy=new int[]{1,0,-1,0};

    private void addDirection(int size){
        for(int i=size-1;i>=0;i--){
            int d=dir.get(i);
            dir.add((d+1)%4);
        }
    }

    private void draw(int x,int y){
        for(int i=0;i<dir.size();i++){
            int d=dir.get(i);
            x+=dx[d];
            y+=dy[d];
            arr[x][y]=1;

        }

    }

    private int check(){
        int res=0;

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(arr[i][j]==1 && arr[i+1][j]==1 && arr[i][j+1]==1 && arr[i+1][j+1]==1)
                    res++;
            }
        }
        return res;
    }

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[101][101];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int g=Integer.parseInt(st.nextToken());

            dir=new ArrayList<>();
            dir.add(d);
            int temp=1;
            while(temp<=g){
                addDirection(dir.size());
                temp++;
            }
            arr[x][y]=1;

            draw(x,y);
        }


        System.out.println(check());
    }
}
