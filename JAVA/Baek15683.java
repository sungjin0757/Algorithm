package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15683 {

    int n,m,num;
    int[][] arr;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int[][][] dir=new int[][][]{{{0},{3},{1},{2}},{{0,1},{2,3}},{{0,2},{0,3},{1,2},{1,3}},
            {{0,2,3},{1,2,3},{2,0,1},{3,0,1}},{{0,1,2,3}}};
    int res=Integer.MAX_VALUE;
    List<int[]> idx=new ArrayList<>();

    private void dfs(int x,int cnt,int[][] map){
        if(cnt==num){
            res=Math.min(res,c(map));
            return;
        }
        int[][] temp=new int[n][m];
        clear(temp,map);


        int[] t=idx.get(x);
        int ca=t[2];

        if(ca==1){
            for(int j=0;j<4;j++){
                int r=t[0];
                int c=t[1];
                int d=dir[0][j][0];
                while(true){
                    r+=dx[d];
                    c+=dy[d];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                dfs(x+1,cnt+1,temp);
                clear(temp,map);

            }
        }else if(ca==2){
            for(int j=0;j<2;j++){
                int r=t[0];
                int c=t[1];

                int d1=dir[1][j][0];
                int d2=dir[1][j][1];
                while(true){
                    r+=dx[d1];
                    c+=dy[d1];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                r=t[0];
                c=t[1];
                while(true){
                    r+=dx[d2];
                    c+=dy[d2];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                dfs(x+1,cnt+1,temp);
                clear(temp,map);
            }
        }else if(ca==3){
            for(int i=0;i<4;i++){
                int r=t[0];
                int c=t[1];

                int d1=dir[2][i][0];
                int d2=dir[2][i][1];
                while(true){
                    r+=dx[d1];
                    c+=dy[d1];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                r=t[0];
                c=t[1];
                while(true){
                    r+=dx[d2];
                    c+=dy[d2];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                dfs(x+1,cnt+1,temp);
                clear(temp,map);
            }

        }else if(ca==4){
            for(int j=0;j<4;j++){
                int r=t[0];
                int c=t[1];

                int d1=dir[3][j][0];
                int d2=dir[3][j][1];
                int d3=dir[3][j][2];
                while(true){
                    r+=dx[d1];
                    c+=dy[d1];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                r=t[0];
                c=t[1];
                while(true){
                    r+=dx[d2];
                    c+=dy[d2];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                r=t[0];
                c=t[1];
                while(true){
                    r+=dx[d3];
                    c+=dy[d3];
                    if(r<0 || r>=n || c<0 || c>=m)
                        break;
                    if(temp[r][c]==0 || temp[r][c]==7){
                        temp[r][c]=7;
                    }
                    else
                        break;
                }
                dfs(x+1,cnt+1,temp);
                clear(temp,map);
            }
        }else if(ca==5){
            int d1=dir[4][0][0];
            int d2=dir[4][0][1];
            int d3=dir[4][0][2];
            int d4=dir[4][0][3];
            int r=t[0];
            int c=t[1];
            while(true){
                r+=dx[d1];
                c+=dy[d1];
                if(r<0 || r>=n || c<0 || c>=m)
                    break;
                if(temp[r][c]==0 || temp[r][c]==7){
                    temp[r][c]=7;
                }
                else
                    break;
            }
            r=t[0];
            c=t[1];
            while(true){
                r+=dx[d2];
                c+=dy[d2];
                if(r<0 || r>=n || c<0 || c>=m)
                    break;
                if(temp[r][c]==0 || temp[r][c]==7){
                    temp[r][c]=7;
                }
                else
                    break;
            }
            r=t[0];
            c=t[1];
            while(true){
                r+=dx[d3];
                c+=dy[d3];
                if(r<0 || r>=n || c<0 || c>=m)
                    break;
                if(temp[r][c]==0 || temp[r][c]==7){
                    temp[r][c]=7;
                }
                else
                    break;
            }
            r=t[0];
            c=t[1];
            while(true){
                r+=dx[d4];
                c+=dy[d4];
                if(r<0 || r>=n || c<0 || c>=m)
                    break;
                if(temp[r][c]==0 || temp[r][c]==7){
                    temp[r][c]=7;
                }
                else
                    break;
            }
            dfs(x+1,cnt+1,temp);
        }
    }
    private void clear(int[][] map1,int[][] map2){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map1[i][j]=map2[i][j];
            }
        }
    }

    private int c(int[][] map){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0)
                    cnt++;
            }
        }
        return cnt;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n][m];
        num=0;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j]= temp;
                if(1<=temp && temp<=5) {
                    num++;
                    idx.add(new int[]{i,j,temp});
                }
            }
        }
        dfs(0,0,arr);
        System.out.println(res);

    }
}
