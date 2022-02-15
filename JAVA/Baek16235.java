package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Baek16235 {

    int n,m,k;
    int[][] arr,A;
    int[] dx=new int[]{-1,-1,-1,0,0,1,1,1};
    int[] dy=new int[]{-1,0,1,-1,1,-1,0,1};
    PriorityQueue<int[]> liveTree;
    Queue<int[]> lq=new LinkedList<>();
    Queue<int[]> dq=new LinkedList<>();

    private void springAndSummer(){

        while(!liveTree.isEmpty()){
            int[] temp = liveTree.poll();
            int x=temp[0];
            int y=temp[1];
            int age=temp[2];

            if(arr[x][y]-age>=0){
                arr[x][y]-=age;
                lq.add(new int[]{x,y,age+1});
            }else if(arr[x][y]-age<0){
                dq.add(new int[]{x,y,age/2});
            }
        }

        while(!dq.isEmpty()){
            int[] temp = dq.poll();
            arr[temp[0]][temp[1]]+=temp[2];
        }
    }

    private void autumn(){
        while(!lq.isEmpty()){
            int[] temp=lq.poll();
            int x=temp[0];
            int y=temp[1];
            int age=temp[2];
            if(age%5==0){
                for(int i=0;i<8;i++){
                    int xx=temp[0]+dx[i];
                    int yy=temp[1]+dy[i];
                    if(1<=xx && xx<=n && 1<=yy && yy<=n){
                        liveTree.offer(new int[]{xx,yy,1});
                    }
                }
            }
            liveTree.add(new int[]{x,y,age});
        }
    }

    private void winter(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j]+=A[i][j];
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[n+1][n+1];
        A=new int[n+1][n+1];
        liveTree=new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[2],o2[2]);
        });

        Arrays.stream(arr).forEach(a->{
            Arrays.fill(a,5);
        });

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());
            liveTree.offer(new int[]{x,y,z});
        }

        for(int i=0;i<k;i++){
            springAndSummer();
            autumn();
            winter();
        }

        System.out.println(liveTree.size());
    }
}
