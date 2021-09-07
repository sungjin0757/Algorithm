package kakao;
import java.util.*;

class ka2021_2 {
    int num,count;
    Map<String,Integer> courseMap;
    int[] temp;
    boolean[] check;

    private void dfs(int x,String value,int t){

        if(x==num){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<num;i++){
                sb.append(value.charAt(temp[i]));
            }
            String course=sb.toString();
            char[] cte=course.toCharArray();
            Arrays.sort(cte);
            course=new String(cte);
            if(courseMap.containsKey(course)){
                courseMap.put(course,courseMap.get(course)+1);
            }
            else{
                courseMap.put(course,1);
            }
        }
        else{
            for(int i=t;i<count;i++){
                if(!check[i]){
                    temp[x]=i;
                    check[x]=true;
                    dfs(x+1,value,i+1);
                    check[x]=false;
                }
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> res=new ArrayList<>();

        for(int i=0;i<course.length;i++){
            num=course[i];
            courseMap=new HashMap<>();
            for(int j=0;j<orders.length;j++){
                if(orders[j].length()>=num){
                    temp=new int[num];
                    check=new boolean[orders[j].length()];
                    count=orders[j].length();
                    dfs(0,orders[j],0);
                }
            }
            int max=0;
            for(int j: courseMap.values()){
                max=Math.max(max,j);
            }
            for(String s:courseMap.keySet()){
                if(courseMap.get(s)==max && max>=2)
                {
                    res.add(s);

                }
            }
        }
        answer=new String[res.size()];
        for(int i=0;i<res.size();i++)
            answer[i]=res.get(i);
        Arrays.sort(answer);

        return answer;
    }
}