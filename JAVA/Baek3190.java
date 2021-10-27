package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek3190 {

    int n,k,l;
    int[][] arr;

    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());

        arr=new int[n+1][n+1];

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine()," ");
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
        }

        l=Integer.parseInt(br.readLine());

        Queue<Point> dq=new LinkedList<>();

        for(int i=0;i<l;i++){
            st=new StringTokenizer(br.readLine()," ");
            dq.offer(new Point(Integer.parseInt(st.nextToken()),st.nextToken()));
        }

        StringBuilder headDir=new StringBuilder();

        headDir.append("R");

        int res=0;
        Deque<Loc> dd=new LinkedList<>();
        dd.offer(new Loc(1,1));

        int[][] check=new int[n+1][n+1];

        check[1][1]=1;

        while(!dq.isEmpty()){
            Point temp=dq.poll();

            int time=temp.time-res;
            String dir=temp.dir;

            boolean finishCheck=false;

            for(int i=0;i<time;i++){
                int tempX=dd.peekFirst().row;
                int tempY=dd.peekFirst().col;
                if(headDir.toString().equals("R")){
                    tempX+=dx[3];
                    tempY+=dy[3];
                }else if(headDir.toString().equals("L")){
                    tempX+=dx[2];
                    tempY+=dy[2];
                }else if(headDir.toString().equals("D")){
                    tempX+=dx[1];
                    tempY+=dy[1];
                }else if(headDir.toString().equals("U")){
                    tempX+=dx[0];
                    tempY+=dy[0];
                }
                if(tempX>=n+1 || tempY>=n+1 || tempX<=0 || tempY<=0){
                    res+=1;
                    finishCheck=true;
                    break;
                }
                if(check[tempX][tempY]==1){
                    res+=1;
                    System.out.println(tempX);
                    System.out.println(tempY);
                    finishCheck=true;
                    break;
                }

                dd.offerFirst(new Loc(tempX,tempY));
                check[tempX][tempY]=1;

                if(arr[tempX][tempY]==1){
                    arr[tempX][tempY]=0;
                }else{
                    Loc ll=dd.removeLast();
                    check[ll.row][ll.col]=0;
                }
                res+=1;
            }

            if(finishCheck){
                break;
            }
            Loc ll=dd.removeFirst();
            int tempX=ll.row;
            int tempY=ll.col;

            if(dd.size()!=0){
                check[tempX][tempY]=0;
            }

            if(dir.equals("L")){
                if(headDir.toString().equals("R")){
                    if(dd.size()!=0) {
                        tempX = dd.peekFirst().row - 1;
                        tempY=dd.peekFirst().col;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("U");
                }else if(headDir.toString().equals("L")){
                    if(dd.size()!=0) {
                        tempX = dd.peekFirst().row + 1;
                        tempY=dd.peekFirst().col;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("D");
                }else if(headDir.toString().equals("D")){
                    if(dd.size()!=0) {
                        tempX=dd.peekFirst().row;
                        tempY = dd.peekFirst().col + 1;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("R");
                }else if(headDir.toString().equals("U")){
                    if(dd.size()!=0) {
                        tempX=dd.peekFirst().row;
                        tempY = dd.peekFirst().col - 1;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("L");
                }
            }else if(dir.equals("D")){
                if(headDir.toString().equals("R")){
                    if(dd.size()!=0) {
                        tempX = dd.peekFirst().row + 1;
                        tempY=dd.peekFirst().col;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("D");
                }else if(headDir.toString().equals("L")){
                    if(dd.size()!=0) {
                        tempX = dd.peekFirst().row - 1;
                        tempY=dd.peekFirst().col;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("U");
                }else if(headDir.toString().equals("D")){
                    if(dd.size()!=0) {
                        tempX=dd.peekFirst().row;
                        tempY = dd.peekFirst().col - 1;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("L");
                }else if(headDir.toString().equals("U")){
                    if(dd.size()!=0) {
                        tempX=dd.peekFirst().row;
                        tempY = dd.peekFirst().col + 1;
                    }
                    headDir.deleteCharAt(0);
                    headDir.append("R");
                }
            }

            if(tempX>=n+1 || tempY>=n+1 || tempX<=0 || tempY<=0) {

                break;
            }
            if(check[tempX][tempY]==1 && dd.size()!=0) {
                break;
            }
            dd.offerFirst(new Loc(tempX,tempY));

        }


        System.out.println(res);

    }

    class Point{
        int time;
        String dir;

        public Point(int time,String dir){
            this.time=time;
            this.dir=dir;
        }
    }

    class Loc{
        int row;
        int col;

        public Loc(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

}
