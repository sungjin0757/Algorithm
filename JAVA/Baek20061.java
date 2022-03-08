package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek20061 {

    int n,t,x,y;
    int[][] green=new int[6][4];
    int[][] blue=new int[4][6];
    int res=0;

    private void process1(){
        int greenIdx=findGreenIdx();
        int blueIdx=findBlueIdx();
        green[greenIdx][y]=1;
        blue[x][blueIdx]=1;
        if(t==2){
            green[greenIdx][y+1]=1;
            blue[x][blueIdx-1]=1;
        }
        if(t==3){
            green[greenIdx-1][y]=1;
            blue[x+1][blueIdx]=1;
        }
    }

    private void process2(){
        while(true){
            if(finishCheck(green,"GREEN"))
                break;
            for(int i=5;i>=0;i--){
                boolean check=true;
                for(int j=0;j<4;j++){
                    if(green[i][j]==0){
                        check=false;
                        break;
                    }
                }
                if(check){
                    point(green,i,"GREEN");
                    res++;
                    break;
                }
            }
        }

        while(true){
            if(finishCheck(blue,"BLUE"))
                break;
            for(int i=5;i>=0;i--){
                boolean check=true;
                for(int j=0;j<4;j++){
                    if(blue[j][i]==0){
                        check=false;
                        break;
                    }
                }
                if(check){
                    point(blue,i,"BLUE");
                    res++;
                    break;
                }
            }
        }
    }

    private void process3(){
        int gr=check2(green,"GREEN");
        int bl=check2(blue,"BLUE");

        for(int i=0;i<gr;i++){
            point(green,5,"GREEN");
        }
        for(int i=0;i<bl;i++){
            point(blue,5,"BLUE");
        }
    }

    private void point(int[][] temp, int idx, String color){
        for(int i=idx-1;i>=0;i--){
            for(int j=0;j<4;j++){
                if(color.equals("GREEN")){
                    temp[i+1][j]=temp[i][j];
                }if(color.equals("BLUE")){
                    temp[j][i+1]=temp[j][i];
                }
                if(i!=0){
                    continue;
                }
                if(color.equals("GREEN")){
                    temp[i][j]=0;
                }if(color.equals("BLUE")){
                    temp[j][i]=0;
                }
            }
        }
    }

    private boolean finishCheck(int[][] temp,String color){
        for(int i=0;i<=5;i++){
            boolean check=true;
            for(int j=0;j<4;j++){
                if(color.equals("GREEN")) {
                    if (temp[i][j] == 0) {
                        check = false;
                        break;
                    }
                }
                if(color.equals("BLUE")){
                    if(temp[j][i]==0){
                        check=false;
                        break;
                    }
                }
            }if(check){
                return false;
            }
        }
        return true;
    }

    private int check2(int[][] temp,String color){
        int num=0;
        for(int i=0;i<=1;i++){
            for(int j=0;j<4;j++){
                if(color.equals("GREEN")){
                    if(temp[i][j]==1){
                        num++;
                        break;
                    }
                }if(color.equals("BLUE")){
                    if(temp[j][i]==1){
                        num++;
                        break;
                    }
                }
            }
        }
        return num;
    }


    private int findGreenIdx(){
        for(int i=0;i<6;i++){
            if(t==2){
                if(green[i][y]==1 || green[i][y+1]==1)
                    return i-1;
            }else {
                if (green[i][y] == 1)
                    return i - 1;
            }
        }
        return 5;
    }

    private int findBlueIdx(){
        for(int i=0;i<6;i++){
            if(t==3){
                if(blue[x][i]==1 || blue[x+1][i]==1)
                    return i-1;
            }else {
                if (blue[x][i] == 1)
                    return i - 1;
            }
        }
        return 5;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            t=Integer.parseInt(st.nextToken());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());

            process1();
            process2();
            process3();
        }

        System.out.println(res);
        System.out.println(Arrays.stream(green).mapToLong(g->Arrays.stream(g).filter(gg->gg==1).count()).sum()+
                Arrays.stream(blue).mapToLong(b->Arrays.stream(b).filter(bb->bb==1).count()).sum());
    }
}
