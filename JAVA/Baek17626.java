package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

public class Baek17626 {

    int n;
    List<Integer> arr=new ArrayList<>();
    int[] temp1;
    boolean check=false;

    private void dfs(int x,int y,int size){
        if(x==size){
            int sum=0;
            for(int i=0;i< temp1.length;i++){
                sum+=temp1[i];
            }
            if(sum==n)
                check=true;
            return;
        }
        if(check)
            return;
        for(int i=y;i<arr.size();i++){

            temp1[x]=arr.get(i);
            dfs(x+1,i,size);

        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        int temp=1;

        while(temp*temp<=n){
            arr.add(temp*temp);
            temp+=1;
        }

        if(arr.contains(n)){
            System.out.println(1);
        }
        else if(!arr.contains(n)) {
            for (int i = 2; i <= 4; i++) {
                temp1 = new int[i];
                dfs(0,0,i);
                if(check){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}