package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1525 {

    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,-1,0,1};

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start=new StringBuilder();

        for(int i=0;i<3;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {

                String temp=st.nextToken();
                if(temp.equals("0")) {
                    start.append("9");
                }
                else
                    start.append(temp);
            }
        }

        Queue<String> dq=new LinkedList<>();
        Map<String,Integer> m=new HashMap<>();
        dq.offer(start.toString());
        m.put(start.toString(),0);

        while(!dq.isEmpty()){
            String present=dq.poll();
            int nineLoc=present.indexOf("9");
            int x=nineLoc/3;
            int y=nineLoc%3;

            for(int i=0;i<4;i++){
                int xx=dx[i]+x;
                int yy=dy[i]+y;
                int move=xx*3+yy;
                if(xx>=0 && xx<3 && yy>=0 && yy<3){
                    StringBuilder next=new StringBuilder(present);
                    char temp=next.charAt(move);
                    next.setCharAt(nineLoc,temp);
                    next.setCharAt(move,'9');
                    String nextStr=next.toString();
                    if(!m.containsKey(nextStr)){
                        dq.offer(nextStr);
                        m.put(nextStr,m.get(present)+1);
                    }
                }
            }
        }

        if(m.containsKey("123456789")){
            System.out.println(m.get("123456789"));
        }
        else{
            System.out.println(-1);
        }

    }
}
