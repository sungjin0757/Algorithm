package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek13460 {

    int n,m;
    char[][] arr;
    int[] dx={-1,0,1,0};
    int[] dy={0,-1,0,1};

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new char[n][m];

        Ball ball=new Ball();
        for(int i=0;i<n;i++)
        {
            String temp=br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=temp.charAt(j);
                if(arr[i][j]=='R')
                {
                    arr[i][j]='.';
                    ball.red=new int[]{i,j};
                }
                if(arr[i][j]=='B'){
                    arr[i][j]='.';
                    ball.blue=new int[]{i,j};
                }
            }
        }

        Queue<Ball> dq=new LinkedList<>();


    }

    class Ball{

        int[] red;
        int[] blue;
        int move;

        public Ball(){
            this.move=0;
        }

        public Ball(Ball ball){
            this.red=ball.red.clone();
            this.blue=ball.blue.clone();
            this.move= ball.move;
        }
    }
}
