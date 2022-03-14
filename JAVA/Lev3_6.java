package programmers;
import java.util.*;
public class Lev3_6 {

    class Solution {
        boolean cc;
        boolean[][] check;
        char[][] b;
        char[][] bbb;
        List<Character> res=new ArrayList<>();
        Map<Character, List<int[]>> map=new HashMap<>();
        int[] dx=new int[]{-1,1,0,0};
        int[] dy=new int[]{0,0,-1,1};

        public String solution(int m, int n, String[] board) {
            String answer = "";
            check=new boolean[m][n];
            b=new char[m][n];
            bbb=new char[m][n];
            int cnt=checkLetter(board);
            int tmp=1;
            while(true){
                if(tmp>cnt){
                    return "IMPOSSIBLE";
                }
                if(res.size()==cnt)
                    break;
                game();
                tmp++;
            }
            Collections.sort(res);
            StringBuilder sb=new StringBuilder();
            for(char c : res){
                sb.append(c);
            }

            return sb.toString();
        }

        private void clear(){
            Arrays.stream(check).forEach(c->Arrays.fill(c,false));
        }

        private void bclear(){
            for(int i=0;i<bbb.length;i++){
                for(int j=0;j<bbb[i].length;j++){
                    b[i][j]=bbb[i][j];
                }
            }
        }

        private void dfs(int x,int y, int endX,int endY,int checkX,int checkY,int cnt,char c){
            if(cc)
                return;
            if(cnt>=2){
                return;
            }
            if(x==endX && y==endY){
                cc=true;
                return;
            }
            for(int i=0;i<4;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];
                if(xx<0 || xx>=b.length || yy<0 || yy>=b[0].length)
                    continue;
                if(b[xx][yy]=='*' || (b[xx][yy]!=c && b[xx][yy]!='.'))
                    continue;
                if(check[xx][yy])
                    continue;
                check[xx][yy]=true;
                if(Math.abs(checkX-xx)>=1 && Math.abs(checkY-yy)>=1){
                    dfs(xx,yy,endX,endY,xx,yy,cnt+1,c);
                }
                else{
                    dfs(xx,yy,endX,endY,checkX,checkY,cnt,c);
                }
                check[xx][yy]=false;
            }
        }

        private void game(){
            bclear();
            List<Character> t=new ArrayList<>();

                for(char c : map.keySet()){
                    if(t.contains(c))
                        continue;
                    List<int[]> temp=map.get(c);
                    int[] startIdx=temp.get(0);
                    int[] endIdx=temp.get(1);
                    clear();
                    check[startIdx[0]][startIdx[1]]=true;
                    cc=false;
                    dfs(startIdx[0],startIdx[1],endIdx[0],endIdx[1],startIdx[0],startIdx[1],0,c);
                    check[startIdx[0]][startIdx[1]]=false;
                    if(cc){
                        b[startIdx[0]][startIdx[1]]='.';
                        b[endIdx[0]][endIdx[1]]='.';
                        res.add(c);
                        t.add(c);
                    }
                }

            for(int i=0;i<t.size();i++){
                char c=t.get(i);
                map.remove(c);
            }
        }

        private int checkLetter(String[] board){
            Set<Character> set=new HashSet<>();
            for(int i=0;i<board.length;i++){
                String s=board[i];
                for(int j=0;j<s.length();j++){
                    char c=s.charAt(j);
                    if(Character.isLetter(c)){
                        set.add(c);
                        if(!map.containsKey(c)){
                            map.put(c,new ArrayList<>());
                        }
                        map.get(c).add(new int[]{i,j});
                    }
                    bbb[i][j]=c;
                }
            }

            return set.size();
        }
    }
}
