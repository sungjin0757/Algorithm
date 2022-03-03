package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17837 {

    int n,k;
    int[][] arr;
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};
    Stack<Integer>[][] stack;
    List<int[]> horse=new ArrayList<>();
    Queue<Integer> dq=new LinkedList<>();
    Stack<Integer> ds=new Stack<>();

    private int reverse(int d){
        if(d==1){
            return 2;
        }if(d==2)
            return 1;
        if(d==3)
            return 4;
        if(d==4)
            return 3;
        return -1;
    }

    private boolean finishCheck(){
        for(int i=1;i<=n;i++){
            if(Arrays.stream(stack[i],1,n+1).filter(s->s.size()>=4).count()>=1)
                return true;
        }
        return false;
    }

    private boolean indexOut(int x,int y){
        if(x<1 || x>n || y<1 || y>n){
            return true;
        }
        if(arr[x][y]==2)
            return true;
        return false;
    }

    private void turn(){
        for(int i=0;i<horse.size();i++){
            int[] temp=horse.get(i);
            int xx=temp[0]+dx[temp[2]-1];
            int yy=temp[1]+dy[temp[2]-1];
            if(indexOut(xx,yy)){
                horse.get(i)[2]=reverse(temp[2]);
                xx=xx-dx[temp[2]-1]+dx[reverse(temp[2])-1];
                yy=yy-dy[temp[2]-1]+dy[reverse(temp[2])-1];
                if(indexOut(xx,yy))
                    continue;
            }
            while(true){
                int idx=stack[temp[0]][temp[1]].pop();
                int[] h=horse.get(idx-1);
                h[0]=xx;
                h[1]=yy;
                if(arr[xx][yy]==0)
                    ds.push(idx);
                else if(arr[xx][yy]==1)
                    dq.offer(idx);

                if(idx-1==i)
                    break;
            }
            if(arr[xx][yy]==0){
                while(!ds.isEmpty()){
                    stack[xx][yy].push(ds.pop());
                }
            }else if(arr[xx][yy]==1){
                while(!dq.isEmpty()){
                    stack[xx][yy].push(dq.poll());
                }
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[n+1][n+1];
        stack=new Stack[n+1][n+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                stack[i][j]=new Stack<>();
            }
        }

        for(int i=1;i<=k;i++){
            st=new StringTokenizer(br.readLine()," ");
            int[] temp=new int[3];
            for(int j=0;j<3;j++){
                temp[j]=Integer.parseInt(st.nextToken());
            }
            stack[temp[0]][temp[1]].push(i);
            horse.add(temp);
        }

        int res=0;

        while(res<=1000){
            if(finishCheck())
                break;
            turn();
            res++;
        }
        if(res>1000) {
            System.out.println(-1);
            return;
        }
        System.out.println(res);
    }
}
