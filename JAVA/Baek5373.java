package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Baek5373 {

    int n;
    String[][][] cube;

    private void rot1(String[][] side,String dir){
        String[] temp=new String[8];
        int t=0;
        for(int i=0;i<4;i++){
            if(i==0 ){
                for(int j=0;j<2;j++){
                    temp[t++]=side[0][j];
                }
            }else if(i==1){
                for(int j=0;j<2;j++){
                    temp[t++]=side[j][2];
                }
            }else if(i==2){
                for(int j=2;j>=1;j--){
                    temp[t++]=side[2][j];
                }
            }else if(i==3){
                for(int j=2;j>=1;j--){
                    temp[t++]=side[j][0];
                }
            }
        }

        String[] temp1=new String[2];

        if(dir.equals("+")){
            swap(temp1,temp,0,2,6,8);
            for(int i=0;i<=6;i+=2){
                String[] ttemp=new String[2];
                swap(ttemp,temp1,0,2,0,2);
                swap(temp1,temp,0,2,i,i+2);
                swap(temp,ttemp,i,i+2,0,2);
            }

        }else if(dir.equals("-")){
            swap(temp1,temp,0,2,0,2);
            for(int i=7;i>=1;i-=2){
                String[] ttemp=new String[2];
                swap(ttemp,temp1,0,2,0,2);
                swap(temp1,temp,0,2,i-1,i+1);
                swap(temp,ttemp,i-1,i+1,0,2);
            }
        }

        t=0;
        for(int i=0;i<4;i++){
            if(i==0 ){
                for(int j=0;j<2;j++){
                    side[0][j]=temp[t++];
                }
            }else if(i==1){
                for(int j=0;j<2;j++){
                    side[j][2]=temp[t++];
                }
            }else if(i==2){
                for(int j=2;j>=1;j--){
                    side[2][j]=temp[t++];
                }
            }else if(i==3){
                for(int j=2;j>=1;j--){
                    side[j][0]=temp[t++];
                }
            }
        }
    }

    private void rot2(String[] side,String dir){
        if(dir.equals("+")){
            String[] temp=new String[3];
            swap(temp,side,0,3,9,12);
            for(int i=0;i<10;i+=3){
                String[] ttemp=new String[3];
                swap(ttemp,temp,0,3,0,3);
                swap(temp,side,0,3,i,i+3);
                swap(side,ttemp,i,i+3,0,3);
            }

        }else if(dir.equals("-")){
            String[] temp=new String[3];
            swap(temp,side,0,3,0,3);
            for(int i=11;i>=2;i-=3){
                String[] ttemp=new String[3];
                swap(ttemp,temp,0,3,0,3);
                swap(temp,side,0,3,i-2,i+1);
                swap(side,ttemp,i-2,i+1,0,3);
            }
        }
    }
    private void swap(String[] s1,String[] s2,int start1,int end1,int start2,int end2){
        for(int i=start1;i<end1;i++){
            s1[i]=s2[start2];
            start2++;
        }
    }

    private void rot3(String[] temp,String dir){
        if (dir.equals("U")) {
            int[] d = new int[]{3, 5, 2, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    cube[d[i]][0][j]=temp[j + (3 * i)];
                }
            }
        } else if (dir.equals("D")) {
            int[] d = new int[]{3, 5, 2, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    cube[d[i]][2][j]=temp[j + (3 * i)];
                }
            }
        } else if (dir.equals("F")) {
            int[] d = new int[]{0, 5, 1, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (d[i] == 0 || d[i] == 1) {
                        cube[d[i]][2][j]=temp[j + (3 * i)];
                    } else if (d[i] == 5) {
                        cube[d[i]][j][0]=temp[j + (3 * i)];
                    } else
                        cube[d[i]][j][2]=temp[j + (3 * i)];
                }
            }
        } else if (dir.equals("B")) {
            int[] d = new int[]{0, 5, 1, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (d[i] == 0 || d[i] == 1) {
                        cube[d[i]][0][j]=temp[j + (3 * i)];
                    } else if (d[i] == 5) {
                        cube[d[i]][j][2]=temp[j + (3 * i)];
                    } else
                        cube[d[i]][j][0]=temp[j + (3 * i)];
                }

            }
        } else if(dir.equals("R")){
            int[] d=new int[]{0,2,1,3};
            for(int i=0;i<d.length;i++){
                for(int j=0;j<3;j++){
                    cube[d[i]][j][2]=temp[j + (3 * i)];
                }
            }
        }else if(dir.equals("L")){
            int[] d=new int[]{0,2,1,3};
            for(int i=0;i<d.length;i++){
                for(int j=0;j<3;j++){
                    cube[d[i]][j][0]=temp[j + (3 * i)];
                }
            }
        }
    }

    private String[] makeCol(String dir) {
        String[] temp = new String[12];
        if (dir.equals("U")) {
            int[] d = new int[]{3, 5, 2, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    temp[j + (3 * i)] = cube[d[i]][0][j];
                }
            }
        } else if (dir.equals("D")) {
            int[] d = new int[]{3, 5, 2, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    temp[j + (3 * i)] = cube[d[i]][2][j];
                }
            }
        } else if (dir.equals("F")) {
            int[] d = new int[]{0, 5, 1, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (d[i] == 0 || d[i] == 1) {
                        temp[j + (3 * i)] = cube[d[i]][2][j];
                    } else if (d[i] == 5) {
                        temp[j + (3 * i)] = cube[d[i]][j][0];
                    } else
                        temp[j + (3 * i)] = cube[d[i]][j][2];
                }
            }
        } else if (dir.equals("B")) {
            int[] d = new int[]{0, 5, 1, 4};
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (d[i] == 0 || d[i] == 1) {
                        temp[j + (3 * i)] = cube[d[i]][0][j];
                    } else if (d[i] == 5) {
                        temp[j + (3 * i)] = cube[d[i]][j][2];
                    } else
                        temp[j + (3 * i)] = cube[d[i]][j][0];
                }

            }
        } else if(dir.equals("R")){
            int[] d=new int[]{0,2,1,3};
            for(int i=0;i<d.length;i++){
                for(int j=0;j<3;j++){
                    temp[j+(3*i)]=cube[d[i]][j][2];
                }
            }
        }else if(dir.equals("L")){
            int[] d=new int[]{0,2,1,3};
            for(int i=0;i<d.length;i++){
                for(int j=0;j<3;j++){
                    temp[j+(3*i)]=cube[d[i]][j][0];
                }
            }
        }
        return temp;
    }


    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            int cnt = Integer.parseInt(br.readLine());
            cube = new String[][][]{{{"w", "w", "w"}, {"w", "w", "w"}, {"w", "w", "w"}},
                    {{"y", "y", "y"}, {"y", "y", "y"}, {"y", "y", "y"}},
                    {{"r", "r", "r"}, {"r", "r", "r"}, {"r", "r", "r"}},
                    {{"o", "o", "o"}, {"o", "o", "o"}, {"o", "o", "o"}},
                    {{"g", "g", "g"}, {"g", "g", "g"}, {"g", "g", "g"}},
                    {{"b", "b", "b"}, {"b", "b", "b"}, {"b", "b", "b"}}};

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<cnt;j++){
                String[] temp=st.nextToken().split("");
                String dir=temp[0];
                String dir1=temp[1];
                if(dir.equals("B") || dir.equals("R") || dir.equals("U")){
                    if(dir1.equals("+"))
                        dir1="-";
                    else
                        dir1="+";
                }
                String[] ttemp=makeCol(dir);
                for (String s : ttemp) {
                    System.out.print(s+" ");
                }
                System.out.println();
                rot2(ttemp,dir1);
                for (String s : ttemp) {
                    System.out.print(s+" ");
                }
                System.out.println();
                rot3(ttemp,dir);

                if(dir.equals("U")){
                    rot1(cube[0],dir1);
                }else if(dir.equals("D")){
                    rot1(cube[1],dir1);
                }else if(dir.equals("F")){
                    rot1(cube[2],dir1);
                }else if(dir.equals("B")){
                    rot1(cube[3],dir1);
                }else if(dir.equals("L")){
                    rot1(cube[4],dir1);
                }else if(dir.equals("R")){
                    rot1(cube[5],dir1);
                }
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(cube[0][j][k]);
                }
                System.out.println();
            }

        }
    }
}
