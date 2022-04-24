package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Baek20056 {

    int n,m,k;
    int[] dx=new int[]{-1,-1,0,1,1,1,0,-1};
    int[] dy=new int[]{0,1,1,1,0,-1,-1,-1};
    Queue<int[]>[][] map;
    List<int[]> shark=new ArrayList<>();

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        map=new LinkedList[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]=new LinkedList<>();
            }
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int[] temp=new int[5];
            for(int j=0;j<5;j++){
                int input = Integer.parseInt(st.nextToken());
                if(j==0 || j==1){
                    input-=1;
                }
                temp[j]= input;
            }
            shark.add(temp);
        }

        for(int i=0;i<k;i++){
            process1();
            process2();
        }
        int[] res = {0};
        shark.stream().forEach(s-> res[0] +=s[2]);
        System.out.println(res[0]);
    }

    private int makeIdx(int val,int d,int s){
        for(int i=0;i<s;i++){
            val+=d;
            if(val==-1){
                val=n-1;
            }else if(val==n){
                val=0;
            }
        }
        return val;
    }

    private void process1(){
        for(int i=0;i<shark.size();i++){
            int[] sh = shark.get(i);
            int s=sh[3];
            int d=sh[4];
            int xx= makeIdx(sh[0],dx[d],s);
            int yy= makeIdx(sh[1],dy[d],s);
            sh[0]=xx;
            sh[1]=yy;
            map[xx][yy].offer(sh);
        }
    }

    private void process2(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j].size()==1){
                    map[i][j].poll();
                }
                if(map[i][j].size()<2){
                    continue;
                }
                int[][] temp=new int[4][5];
                int m=0;
                int s=0;
                int size=map[i][j].size();
                int check=0;
                while(!map[i][j].isEmpty()){
                    int[] pollShark = map[i][j].poll();
                    shark.remove(pollShark);
                    m+=pollShark[2];
                    s+=pollShark[3];
                    check+=pollShark[4];
                }
                m/=5;
                s/=size;
                if(m==0){
                    continue;
                }
                for(int k=0;k<=6;k+=2){
                    int idx=k;
                    if(check%2==1){
                        idx+=1;
                    }
                    temp[k/2][0]=i;
                    temp[k/2][1]=j;
                    temp[k/2][2]=m;
                    temp[k/2][3]=s;
                    temp[k/2][4]=idx;
                }
                for(int k=0;k<4;k++){
                    shark.add(temp[k]);
                }
            }
        }
    }
}
