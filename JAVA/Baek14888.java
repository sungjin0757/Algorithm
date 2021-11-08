package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class Baek14888 {

    int n;
    int[] arr;
    List<String> op=new ArrayList<>();
    String[] opTemp;
    boolean[] check;
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;

    private void addOp(String s,int size){
        for(int i=0;i<size;i++){
            op.add(s);
        }
    }

    private int cal(){
        int r=arr[0];

        for(int i=0;i<n-1;i++){
            if(opTemp[i].equals("+")){
                r+=arr[i+1];
            }else if(opTemp[i].equals("*")){
                r*=arr[i+1];
            }else if(opTemp[i].equals("-")){
                r-=arr[i+1];
            }else if(opTemp[i].equals("/")){
                r/=arr[i+1];
            }
        }

        return r;
    }

    private void dfs(int x){
        if(x==n-1){
            int c=cal();
            max=Math.max(c,max);
            min=Math.min(c,min);
            return;
        }

        for(int i=0;i<n-1;i++){
            if(!check[i]){
                opTemp[x]=op.get(i);
                check[i]=true;
                dfs(x+1);
                check[i]=false;
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++){
            int temp=Integer.parseInt(st.nextToken());
            if(i==0){
                addOp("+",temp);
            }else if(i==1){
                addOp("-",temp);
            }else if(i==2){
                addOp("*",temp);
            }else if(i==3){
                addOp("/",temp);
            }
        }
        opTemp=new String[n-1];
        check=new boolean[n-1];
        dfs(0);


        System.out.println(max);
        System.out.println(min);
    }
}
