package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1525 {

    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,-1,0,1};

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int start=0;

        for(int i=0;i<3;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {

                int temp=Integer.parseInt(st.nextToken());
                if(temp==0) {
                    temp = 9;
                }
                start=(10*start)+temp;
            }
        }

        Queue<Integer> dq=new LinkedList<>();
        Map<Integer,Integer> m=new HashMap<>();
        dq.offer(start);
        m.put(start,0);

        while(!dq.isEmpty()){
            int present=dq.poll();
            String now=String.valueOf(present);
            int nineLoc=now.indexOf("9");
            int x=nineLoc/3;
            int y=nineLoc%3;

            for(int i=0;i<4;i++){
                int xx=dx[i]+x;
                int yy=dy[i]+y;
                int move=xx*3+yy;
                if(xx>=0 && xx<3 && yy>=0 && yy<3){
                    StringBuilder next=new StringBuilder(String.valueOf(present));
                    char temp=next.charAt(move);
                    next.setCharAt(nineLoc,temp);
                    next.setCharAt(move,'9');
                    int num=Integer.parseInt(next.toString());
                    if(!m.containsKey(num)){
                        dq.offer(num);
                        m.put(num,m.get(present)+1);
                    }
                }
            }
        }

        if(m.containsKey(123456789)){
            System.out.println(m.get(123456789));
        }
        else{
            System.out.println(-1);
        }

    }
}
