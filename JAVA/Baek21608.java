package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek21608 {

    int n;
    int[] order;
    List<Integer>[] love;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int[][] res;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        order=new int[n*n+1];
        love=new ArrayList[n*n+1];
        res=new int[n+1][n+1];

        StringTokenizer st=null;

        for(int i=1;i<=n*n;i++){
            st=new StringTokenizer(br.readLine()," ");
            int temp=Integer.parseInt(st.nextToken());

            order[i]=temp;
            love[temp]=new ArrayList<>();

            for(int j=0;j<4;j++){
                love[temp].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=1;i<=n*n;i++){
            int temp=order[i];
            List<int[]> t=new ArrayList<>();

            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(res[j][k]==0)
                        t.add(new int[]{j,k,one(j,k,temp),two(j,k)});
                }
            }
            t.sort((o1,o2)->{
                if(o1[2]==o2[2]){
                    if(o1[3]==o2[3]) {
                        if (o1[0] == o2[0])
                            return Integer.compare(o1[1], o2[1]);
                        return Integer.compare(o1[0], o2[0]);
                    }
                    return Integer.compare(-o1[3],-o2[3]);
                }
                return Integer.compare(-o1[2],-o2[2]);
            });


            res[t.get(0)[0]][t.get(0)[1]]=temp;
        }

        int re=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int temp=one(i,j,res[i][j]);
                if(temp==1)
                    re+=1;
                else if(temp==2)
                    re+=10;
                else if(temp==3)
                    re+=100;
                else if(temp==4)
                    re+=1000;
            }
        }

        System.out.println(re);
    }


    private int one(int x,int y,int me){
        int s=0;
        List<Integer> temp=love[me];

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];

            if(1<=xx && xx<=n && 1<=yy && yy<=n){
                if(temp.contains(Integer.valueOf(res[xx][yy])))
                    s++;
            }
        }

        return s;
    }

    private int two(int x,int y){
        int s=0;

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];

            if(1<=xx && xx<=n && 1<=yy && yy<=n){
                if(res[xx][yy]==0)
                    s++;
            }
        }

        return s;
    }
}
