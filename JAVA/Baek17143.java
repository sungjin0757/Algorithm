package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek17143 {

    int R,C,M;
    Queue<int[]>[][] pq;
    int res=0;

    private int maxShark(int col){
        int temp=0;
        for(int i=1;i<=R;i++){
            if(pq[i][col]==null)
                continue;
            if(pq[i][col].isEmpty())
                continue;
            temp= pq[i][col].poll()[2];
            break;
        }
        return temp;
    }

    private int m(int c,int s,int d){
        while(s>0) {
            if (d == 1) {
                c--;
                if(c==1)
                    d=2;
            } else if (d == 2) {
                c++;
                if(c==R)
                    d=1;
            } else if (d == 3) {
                c++;
                if(c==C)
                    d=4;
            } else if (d == 4) {
                c--;
                if(c==1)
                    d=3;
            }
            s--;
        }
        return c;
    }

    private void move(){
        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++){
                if(pq[i][j]==null)
                    continue;
                if(pq[i][j].isEmpty())
                    continue;
                int[] temp=pq[i][j].poll();
                int s=temp[0];
                int d=temp[1];
                int z=temp[2];
                int c=0;
                boolean check=true;
                if(d==1 || d==2){
                    c=m(i,s,d);
                    if(pq[c][j]==null){
                        pq[c][j]=new LinkedList<>();
                    }else{
                        if(!pq[c][j].isEmpty()){
                            if(z>pq[c][j].peek()[2]){
                                pq[c][j].poll();
                            }
                            else{
                                check=false;
                            }
                        }
                    }
                    if(check){
                        pq[c][j].offer(new int[]{s,d,z});
                    }
                }else if(d==3 || d==4){
                    c=m(j,s,d);
                    System.out.println(c+" "+j+" "+d+" "+s);
                    if(pq[i][c]==null){
                        pq[i][c]=new LinkedList<>();
                    }else{
                        if(!pq[i][c].isEmpty()){
                            if(z>pq[i][c].peek()[2]){
                                pq[i][c].poll();
                            }else
                                check=false;
                        }
                    }
                    if(check){
                        pq[i][c].offer(new int[]{s,d,z});
                    }
                }
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        pq=new LinkedList[R+1][C+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());

            if(pq[r][c]==null) {
                pq[r][c] = new LinkedList<>();
            }
            pq[r][c].offer(new int[]{s,d,z});
        }

        for(int i=1;i<=C;i++){
            res+=maxShark(i);
            move();
        }
        System.out.println(res);
    }
}
