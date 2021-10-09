package kakao;
import java.util.*;

public class Ka19_2 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        answer=new int[N];

        List<Double[]> arr=new ArrayList<>();

        for(int i=1;i<N+1;i++){
            double temp=0;
            double temp1=0;
            for(int s : stages){
                if(s>=i)
                    temp+=1;
                if(s==i)
                    temp1+=1;
            }
            arr.add(new Double[]{(double)i,temp1/temp});
        }
        Collections.sort(arr,(o1,o2)->{
            if(o1[1]==o2[1])
                return Double.compare(o1[0],o2[0]);
            return Double.compare(-o1[1],-o2[1]);
        });

        for(int i=0;i<arr.size();i++){
            Double[] temp=arr.get(i);
            answer[i]=temp[0].intValue();
        }
        return answer;
    }
}
