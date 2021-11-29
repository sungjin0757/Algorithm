package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baek1699 {

    int n;
    List<Integer> arr=new ArrayList<>();
    int[] temp1;
    boolean check;

    private int sum(int[] t){
        return Arrays.stream(t).sum();
    }

    private void dfs(int x,int y,int size){

        if(x==size){
            if(sum(temp1)==n){
                check=true;
            }
            return;
        }
        if(check)
            return;
        if(x!=size){
            for(int i=y;i<arr.size();i++){
                temp1[x]=arr.get(i);
                dfs(x+1,i,size);
            }
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


        for(int i=1;i<=n;i++){
            temp1=new int[i];
            check=false;
            dfs(0,0,i);

            if(check) {
                System.out.println(i);
                break;
            }
        }
    }
}
