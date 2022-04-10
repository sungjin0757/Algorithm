package programmers;
import java.util.*;
public class Lev3_23 {
    class Solution {
        List<int[]> list=new ArrayList<>();
        Node root;
        List<Integer> pre=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        private void preOrder(Node node){
            if(node==null){
                return;
            }
            pre.add(node.number);
            preOrder(node.left);
            preOrder(node.right);
        }
        private void postOrder(Node node){
            if(node==null){
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            post.add(node.number);
        }
        private void insertNode(Node parent,Node child){
            if(parent.x>child.x){
                if(parent.left==null){
                    parent.left=child;
                }else{
                    insertNode(parent.left,child);
                }
            }else if(parent.x<child.x){
                if(parent.right==null){
                    parent.right=child;
                }else{
                    insertNode(parent.right,child);
                }
            }
        }
        public int[][] solution(int[][] nodeinfo) {
            for(int i=0;i<nodeinfo.length;i++){
                list.add(new int[]{i+1,nodeinfo[i][0],nodeinfo[i][1]});
            }
            Collections.sort(list,(o1,o2)->{
                if(o1[2]==o2[2]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(-o1[2],-o2[2]);
            });
            root=new Node(list.get(0)[0],list.get(0)[1],list.get(0)[2]);
            for(int i=1;i<nodeinfo.length;i++){
                int[] temp=list.get(i);
                insertNode(root,new Node(temp[0],temp[1],temp[2]));
            }
            preOrder(root);
            postOrder(root);
            int[][] answer = new int[2][nodeinfo.length];
            for(int i=0;i<2;i++){
                for(int j=0;j<nodeinfo.length;j++){
                    if(i==0){
                        answer[i][j]=pre.get(j);
                    }else{
                        answer[i][j]=post.get(j);
                    }
                }
            }
            return answer;
        }
        class Node{
            int number;
            int x;
            int y;
            Node left;
            Node right;
            public Node(int number,int x,int y){
                this.number=number;
                this.x=x;
                this.y=y;
            }
        }
    }
}
