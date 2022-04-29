package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek21609 {
    int n,m;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int[][] arr;
    boolean[][] check;
    PriorityQueue<List<Block>> pq=new PriorityQueue<>((o1,o2)->{
        if(o1.size()==o2.size()){
            if(rainbowCnt(o1)==rainbowCnt(o2)){
                Block o1Standard = standard(o1);
                Block o2Standard = standard(o2);
                if(o1Standard.row== o2Standard.row){
                    return Integer.compare(-o1Standard.col, -o2Standard.col);
                }
                return Integer.compare(-o1Standard.row, -o2Standard.col);
            }
            return Integer.compare(-rainbowCnt(o1),-rainbowCnt(o2));
        }
        return Integer.compare(-o1.size(),-o2.size());
    });
    long res=0;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n][n];
        check=new boolean[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            clear();
            stage1();
            if(finishCheck()){
                break;
            }
            stage2();
            gravity();
            stage3();
            gravity();
        }

        System.out.println(res);
    }

    private boolean finishCheck(){
        for (List<Block> blocks : pq) {
            if(blocks.size()>=2){
                for (Block block : blocks) {
                    if(!block.rainbow){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void clear(){
        pq.clear();
        Arrays.stream(check).forEach(c->Arrays.fill(c,false));
    }

    private void stage1(){
        clear();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==-1 || check[i][j] || arr[i][j]==-3)
                    continue;
                pq.offer(bfs(i,j));
            }
        }
    }

    private void stage2(){
        List<Block> poll = pq.poll();
        res+= poll.size()*poll.size();
        for (Block block : poll) {
            arr[block.row][block.col]=-3;
        }
    }

    private void gravity(){
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(arr[i][j]==-3 || arr[i][j]==-1)
                    continue;
                for(int k=i+1;k<n;k++){
                    if(arr[k][j]!=-3){
                        break;
                    }
                    arr[k][j] = arr[k-1][j];
                    arr[k-1][j]=-3;
                }
            }
        }
    }

    private void stage3(){
        int rowStart=0;
        int rowEnd=n;
        int colStart=0;
        int colEnd=n;
        for(int i=n;i>1;i-=2){
            for(int j=0;j<i-1;j++){
                rotate(rowStart,rowEnd,colStart,colEnd);
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
    }

    private void rotate(int rowStart,int rowEnd,int colStart,int colEnd){
        int temp=arr[rowStart+1][colEnd-1];

        for(int i=colEnd-1;i>=colStart;i--){
            int ttemp=arr[rowStart][i];
            arr[rowStart][i]=temp;
            temp=ttemp;
        }

        for(int i=rowStart+1;i<rowEnd;i++){
            int ttemp=arr[i][colStart];
            arr[i][colStart]=temp;
            temp=ttemp;
        }

        for(int i=colStart+1;i<colEnd;i++){
            int ttemp=arr[rowEnd-1][i];
            arr[rowEnd-1][i]=temp;
            temp=ttemp;
        }

        for(int i=rowEnd-2;i>rowStart-1;i--){
            int ttemp=arr[i][colEnd-1];
            arr[i][colEnd-1]=temp;
            temp=ttemp;
        }
    }

    private List<Block> bfs(int x,int y){
        Queue<Block> dq=new LinkedList<>();
        List<Block> blocks=new ArrayList<>();
        Block block = new Block(x, y, arr[x][y] == 0 ? true : false);
        dq.offer(block);
        List<int[]> rainBowIdx=new ArrayList<>();

        while(!dq.isEmpty()){
            Block pollBlock = dq.poll();
            blocks.add(pollBlock);
            check[pollBlock.row][pollBlock.col]=true;
            if(pollBlock.rainbow){
                rainBowIdx.add(new int[]{pollBlock.row, pollBlock.col});
            }

            for(int i=0;i<4;i++){
                int xx=dx[i]+pollBlock.row;
                int yy=dy[i]+pollBlock.col;

                if(xx<0 || xx>=n || yy<0 || yy>=n){
                    continue;
                }
                if(arr[xx][yy]==-1 || (arr[xx][yy]!=arr[x][y]&&arr[xx][yy]!=0) || check[xx][yy]
                || arr[xx][yy]==-3){
                    continue;
                }
                dq.offer(new Block(xx, yy, arr[xx][yy] == 0 ? true : false));
                check[xx][yy]=true;
            }
        }
        Collections.sort(blocks,(o1,o2)->{
            if(o1.row==o2.row){
                return Integer.compare(o1.col,o2.col);
            }
            return Integer.compare(o1.row,o2.row);
        });
        blocks.get(0).standard=true;
        for (int[] r : rainBowIdx) {
            check[r[0]][r[1]]=false;
        }

        return blocks;
    }

    private int rainbowCnt(List<Block> block){
        return (int)block.stream().filter(b->b.rainbow==true).count();
    }

    private Block standard(List<Block> block){
        return block.stream().filter(b->b.standard==true).findFirst().get();
    }

    class Block{
        int row;
        int col;
        boolean rainbow;
        boolean standard;

        public Block(int row,int col,boolean rainbow){
            this.row=row;
            this.col=col;
            this.rainbow=rainbow;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "row=" + row +
                    ", col=" + col +
                    ", rainbow=" + rainbow +
                    ", standard=" + standard +
                    '}';
        }
    }
}
