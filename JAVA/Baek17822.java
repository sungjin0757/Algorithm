package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek17822 {

    int n,m,t;
    int[][] arr;
    boolean[][] check;

    private int res(){
        return Arrays.stream(arr).mapToInt(a -> Arrays.stream(a).filter(aa->aa!=-1).sum()).sum();
    }

    private double z(){
        return Arrays.stream(arr).mapToDouble(a->
            Arrays.stream(a).filter(aa->aa!=-1 && aa!=0).count()
        ).sum();
    }

    private void rot(int[] temp,int dir,int k){
        while(k>0){
            if(dir==0)
                rot0(temp);
            else if(dir==1)
                rot1(temp);
            k--;
        }
    }

    private void rot0(int[] temp){
        int t=temp[m];
        for(int i=1;i<=m;i++){
            int tt=t;
            t=temp[i];
            temp[i]=tt;
        }
    }

    private void rot1(int[] temp){
        int t=temp[1];
        for(int i=m;i>=1;i--){
            int tt=t;
            t=temp[i];
            temp[i]=tt;
        }
    }

    private void process(){
        clear();
        boolean c=false;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i][j]==-1)
                    continue;
                if(j==m){
                    if(arr[i][j]==arr[i][1]){
                        check[i][j]=true;
                        check[i][1]=true;
                        c=true;
                    }
                }
                else if(arr[i][j]==arr[i][j+1]){
                    check[i][j]=true;
                    check[i][j+1]=true;
                    c=true;
                }
                if(i==n)
                    continue;
                if(arr[i][j]==arr[i+1][j]){
                    check[i][j]=true;
                    check[i+1][j]=true;
                    c=true;
                }
            }
        }

        zero();
        if(!c)
            ps();
    }

    private void zero(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(check[i][j] ) {
                    arr[i][j] = -1;
                }
            }
        }
    }

    private void ps(){
        double idx=z();
        double sum=res();
        if(idx==0)
            return;
        double avg=sum/idx;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i][j]==-1)
                    continue;
                if(avg>arr[i][j])
                    arr[i][j]+=1;
                else if(avg<arr[i][j])
                    arr[i][j]-=1;
            }
        }
    }

    private void clear(){
        Arrays.stream(check).forEach(c->{
            Arrays.fill(c,false);
        });
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        arr=new int[n+1][m+1];
        check=new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            int temp=x;
            int idx=1;
            while(temp<=n){
                rot(arr[temp],d,k);
                idx++;
                temp*=idx;
            }

            process();

        }
        System.out.println(res());
    }
}
