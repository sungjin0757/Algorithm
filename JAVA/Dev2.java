package programmers;

import java.util.*;

public class Dev2 {
    int[][] arr;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        arr=new int[rows+1][columns+1];

        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                arr[i][j]=j+(i-1)*columns;
            }
        }

        answer=new int[queries.length];

        int k=0;

        for(int[] i:queries){
            answer[k]=rotate(i[0],i[1],i[2],i[3]);
            k++;
        }

        return answer;
    }

    private int rotate(int r1,int c1,int r2,int c2){
        int temp=arr[r1][c1];
        List<Integer> a=new ArrayList<>();

        for(int i=c1+1;i<=c2;i++){
            int temp1=arr[r1][i];
            arr[r1][i]=temp;
            temp=temp1;
            a.add(temp1);
        }

        for(int i=r1+1;i<=r2;i++){
            int temp1=arr[i][c2];
            arr[i][c2]=temp;
            temp=temp1;
            a.add(temp1);
        }

        for(int i=c2-1;i>=c1;i--){
            int temp1=arr[r2][i];
            arr[r2][i]=temp;
            temp=temp1;
            a.add(temp1);
        }

        for(int i=r2-1;i>=r1;i--){
            int temp1=arr[i][c1];
            arr[i][c1]=temp;
            temp=temp1;
            a.add(temp1);
        }
        return Collections.min(a);
    }
}
