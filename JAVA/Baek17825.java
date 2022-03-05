package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek17825 {

    int [] dice=new int[11];
    Node start;
    int[] horse=new int[11];
    Node[] loc=new Node[5];
    int res=Integer.MIN_VALUE;

    private void dfs(int x){
        if(x==11){
            clear();
            res=Math.max(res,process());
            return;
        }

        for(int i=1;i<=4;i++){
            horse[x]=i;
            dfs(x+1);
        }
    }

    private void clear(){
        for(int i=1;i<=4;i++){
            loc[i]=start;
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        for(int i=1;i<=10;i++){
            dice[i]=Integer.parseInt(st.nextToken());
        }
        init();
        dfs(1);

        System.out.println(res);
    }

    private int process(){
        int temp=0;
        for(int i=1;i<=10;i++){
            if(move(horse[i],dice[i])){
                temp=0;
                break;
            }
            temp+=loc[horse[i]].point;

        }
        for(int i=1;i<=4;i++){
            loc[i].isFull=false;
        }
        return temp;
    }

    private boolean move(int hor,int dis){
        loc[hor].isFull=false;
        if(loc[hor].blueNext!=null){
            dis-=1;
            loc[hor]=loc[hor].blueNext;
        }
        for(int i=0;i<dis;i++){
            loc[hor]=loc[hor].redNext;
        }
        if(loc[hor].isFull && !loc[hor].isEnd)
            return true;
        loc[hor].isFull=true;

        return false;
    }

    private void init(){
        start=new Node(0);

        Node temp=start;
        for(int i=2;i<=40;i+=2){
            temp=temp.addRedDirection(i);
        }
        Node end=temp.addRedDirection(0);
        end.isEnd=true;
        end.redNext=end;

        Node cross=new Node(25);
        temp=cross.addRedDirection(30);
        temp=temp.addRedDirection(35);
        temp.redNext=temp.getNode(start,40);

        temp=temp.getNode(start,10);
        temp=temp.blueNext=new Node(13);
        temp=temp.addRedDirection(16);
        temp=temp.addRedDirection(19);
        temp.redNext=cross;

        temp=temp.getNode(start,20);
        temp=temp.blueNext=new Node(22);
        temp=temp.addRedDirection(24);
        temp.redNext=cross;

        temp=temp.getNode(start,30);
        temp=temp.blueNext=new Node(28);
        temp=temp.addRedDirection(27);
        temp=temp.addRedDirection(26);
        temp.redNext=cross;

    }

    class Node{
        int point;
        Node redNext;
        Node blueNext;
        boolean isFull;
        boolean isEnd;

        public Node( int point){
            this.point=point;
        }

        public Node addRedDirection(int point){
            Node newNode=new Node(point);
            this.redNext=newNode;
            return newNode;
        }

        public Node getNode(Node start,int point){
            Node temp=start;
            while(true){
                if(temp==null)
                    return null;
                if(temp.point==point)
                    return temp;
                temp=temp.redNext;
            }
        }
    }
}
