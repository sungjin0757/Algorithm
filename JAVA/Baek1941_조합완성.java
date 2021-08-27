package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1941 {

    char[][] arr=new char[5][5];
    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,-1,0,1};
    boolean[] check=new boolean[25];
    int[] temp=new int[7];
    List<int[]> path=new ArrayList<>();

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++){
            String[] split = br.readLine().split("");
            for(int j=0;j<5;j++){
                arr[i][j]=split[j].charAt(0);
            }
        }
    }

    public void dfs(int x){
        if(x==7){
            if(numCheck(temp)){
                path.add(temp.clone());
            }
        }
        else {
            for (int i = x; i < 25; i++) {
                if (!check[i]) {
                    check[i] = true;
                    temp[x]=i;
                    dfs(x + 1);
                }
            }
        }
    }

    public boolean numCheck(int[] combList){
        int y=0;
        int s=0;

        for(int i=0;i<7;i++){
            int temp=combList[i];

            int row=temp/5;
            int col=temp%5;
            if(arr[row][col]=='Y'){
                y++;
            }
            else{
                s++;
            }

            if(y>3)
                return false;
        }

        return true;
    }
}
