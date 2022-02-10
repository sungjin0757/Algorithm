package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15686 {

    int n,m;
    int[][] arr;
    List<int[]> chicken=new ArrayList<>();
    int[] temp;
    int res=Integer.MAX_VALUE;

    private void dfs(int x,int y){
        if(y==m){
            res=Math.min(cir(temp),res);
            return;
        }
        for(int i=x;i<chicken.size();i++){
            temp[y]=i;
            dfs(i+1,y+1);
        }
    }

    private int cir(int[] idx){
        int temp1=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(arr[i][j]==1){
                    int temp2=Integer.MAX_VALUE;
                    for(int k=0;k<idx.length;k++){
                        int[] dir=chicken.get(idx[k]);
                        temp2=Math.min(temp2,Math.abs((i-dir[0]))+Math.abs((j-dir[1])));
                    }
                    temp1+=temp2;
                }
            }
        }
        return temp1;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n+1][n+1];
        temp=new int[m];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    chicken.add(new int[]{i,j});
                }
            }
        }
        dfs(0,0);
        System.out.println(res);
    }
}
