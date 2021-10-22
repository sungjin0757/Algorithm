package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek12100 {

    int n;
    int[][][][] dp;
    int max=0;

    private void dfs(int x,int pre,int next){

        int[][] temp = new int[n][n];
        boolean[][] check=new boolean[n][n];

        if(x>=1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = dp[x - 1][pre][i][j];
                }
            }

            for (int[] t : temp) {
                max = Math.max(max, Arrays.stream(t).max().getAsInt());
            }

            if(x==6)
                return;

            if (next == 0) {
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int tempIdx = i;
                        boolean check1=false;
                        while (true) {
                            if (tempIdx <= 0)
                                break;
                            if (temp[tempIdx - 1][j] == temp[tempIdx][j] || temp[tempIdx - 1][j] == 0) {
                                if (check[tempIdx - 1][j]) {
                                    break;
                                }
                                if (temp[tempIdx - 1][j] != 0) {
                                    check1=true;
                                }
                                temp[tempIdx - 1][j] += temp[tempIdx][j];
                                temp[tempIdx][j] = 0;

                                tempIdx--;
                            } else {
                                break;
                            }
                        }
                        if(check1)
                            check[tempIdx][j]=true;
                    }
                }

            } else if (next == 1) {
                for (int i = n - 2; i >= 0; i--) {
                    for (int j = 0; j < n; j++) {
                        int tempIdx = i;
                        boolean check1=false;
                        while (true) {
                            if (tempIdx >= n - 1)
                                break;
                            if (temp[tempIdx + 1][j] == temp[tempIdx][j] || temp[tempIdx + 1][j] == 0) {
                                if (check[tempIdx + 1][j]) {
                                    break;
                                }
                                if (temp[tempIdx + 1][j] != 0) {
                                    check1 = true;
                                }
                                temp[tempIdx + 1][j] += temp[tempIdx][j];
                                temp[tempIdx][j] = 0;

                                tempIdx++;
                            } else {
                                break;
                            }
                        }
                        if(check1)
                            check[tempIdx][j]=true;
                    }
                }

            } else if (next == 2) {
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int tempIdx = i;
                        boolean check1=false;
                        while (true) {
                            if (tempIdx <= 0)
                                break;
                            if (temp[j][tempIdx - 1] == temp[j][tempIdx] || temp[j][tempIdx - 1] == 0) {
                                if (check[j][tempIdx - 1]) {
                                    break;
                                }
                                if (temp[j][tempIdx - 1] != 0) {
                                    check1 = true;
                                }
                                temp[j][tempIdx - 1] += temp[j][tempIdx];
                                temp[j][tempIdx] = 0;

                                tempIdx--;
                            } else {
                                break;
                            }
                        }
                        if(check1)
                            check[j][tempIdx]=true;
                    }
                }

            } else if (next == 3) {
                for (int i = n - 2; i >= 0; i--) {
                    for (int j = 0; j < n; j++) {
                        int tempIdx = i;
                        boolean check1=false;
                        while (true) {
                            if (tempIdx >= n - 1)
                                break;
                            if (temp[j][tempIdx + 1] == temp[j][tempIdx] || temp[j][tempIdx + 1] == 0) {
                                if (check[j][tempIdx + 1]) {
                                    break;
                                }
                                if (temp[j][tempIdx + 1] != 0) {
                                    check1 = true;

                                }
                                temp[j][tempIdx + 1] += temp[j][tempIdx];
                                temp[j][tempIdx] = 0;

                                tempIdx++;
                            } else {
                                break;
                            }
                        }
                        if(check1)
                            check[j][tempIdx]=true;
                    }
                }

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[x][next][i][j] = temp[i][j];
                }
            }
        }
        dfs(x+1,next,0);
        dfs(x+1,next,1);
        dfs(x+1,next,2);
        dfs(x+1,next,3);
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        dp=new int[6][4][n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");

            for(int j=0;j<n;j++){
                dp[0][0][i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);

        System.out.println(max);
    }
}
