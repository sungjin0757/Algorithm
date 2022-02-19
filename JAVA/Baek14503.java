package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14503 {

    int n,m,r,c,d;
    int[][] arr;
    int res=0;
    boolean[][] check;

    private void rot(){
        if(d==0)
            d = 3;
        else if(d==1)
            d = 0;
        else if(d==2)
            d = 1;
        else
            d = 2;
    }

    private void clean(){
        if(!check[r][c]){
            check[r][c]=true;
            res++;
        }

        boolean cc=false;

        for(int i=0;i<4;i++) {
            rot();
            if (d == 0) {
                if (r - 1 >= 0) {
                    if (arr[r - 1][c] == 0 && !check[r - 1][c]) {
                        r -= 1;
                        cc = true;
                    }
                }
            }
            if (d == 1) {
                if (c + 1 < m) {
                    if (arr[r][c + 1] == 0 && !check[r][c + 1]) {
                        c += 1;
                        cc = true;
                    }
                }
            }
            if (d == 2) {
                if (r + 1 < n) {
                    if (arr[r + 1][c] == 0 && !check[r + 1][c]) {
                        r += 1;
                        cc = true;
                    }
                }
            }
            if (d == 3) {
                if (c - 1 >= 0) {
                    if (arr[r][c - 1] == 0 && !check[r][c - 1]) {
                        c -= 1;
                        cc = true;
                    }

                }
            }
            if(cc)
                break;
        }

        if(cc){
            clean();
        }
        else if(!cc){
            if(d==0)
                r+=1;
            else if(d==1)
                c-=1;
            else if(d==2)
                r-=1;
            else
                c+=1;
            if(0<=r && r<n && 0<=c && c<m){
                if(arr[r][c]!=1){
                    clean();
                }
            }
        }

    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine(), " ");
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());

        arr=new int[n][m];
        check=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        clean();

        System.out.println(res);
    }
}
