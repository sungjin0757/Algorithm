package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Baek11725 {

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        List<Integer>[] tree=new ArrayList[n+1];

        for(int i=1;i<tree.length;i++){
            tree[i]=new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());

            tree[temp1].add(temp2);
            tree[temp2].add(temp1);
        }

        Queue<Integer> dq=new LinkedList<>();
        dq.offer(1);
        boolean[] check=new boolean[n+1];

        while(!dq.isEmpty()){
            int present=dq.poll();
            check[present]=true;
            List<Integer> baby=new ArrayList<>();
            for(int i:tree[present]){
                if(!check[i]) {
                    baby.add(i);
                    dq.offer(i);
                }
            }
            for(int i:baby){
                tree[present].remove((Integer)i);
            }
        }

        for(int i=2;i<tree.length;i++){
            System.out.println(tree[i].get(0));
        }

    }
}
