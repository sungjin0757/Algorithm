package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14890 {

    int n,l;
    int[][] arr;
    int res=0;

    private boolean check(int x,int flag){
        int[] temp=new int[n];
        boolean[] visit=new boolean[n];

        for(int i=0;i<n;i++){
            if(flag==0)
                temp[i]=arr[i][x];
            if(flag==1)
                temp[i]=arr[x][i];
        }

        for(int i=0;i<n-1;i++){
            if(temp[i]==temp[i+1])
                continue;
            else if(temp[i]==temp[i+1]+1){
                for(int j=i+1;j<=i+l;j++){
                    if(j>=n || temp[i+1]!=temp[j] || visit[j])
                        return false;
                    visit[j]=true;
                }
            }else if(temp[i]==temp[i+1]-1){
                for(int j=i;j>i-l;j--){
                    if(j<0 || temp[i]!=temp[j] || visit[j])
                        return false;
                    visit[j]=true;
                }
            }else
                return false;
        }
        return true;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        arr=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            if(check(i,0))
                res++;
            if(check(i,1))
                res++;
        }
        System.out.println(res);
    }
}
