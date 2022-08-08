package kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ka19I_1 {
    private String expression;
    private int[] res;

    private void parseExpression() {
        String[] splitExp = expression.split("},");
        initRes(splitExp.length);
        for (int i = 0; i < splitExp.length; i++) {
            splitExp[i] = splitExp[i].replace("}", "").replace("{", "");
        }
        Arrays.sort(splitExp, (o1, o2) -> {
           return Integer.compare(o1.length(), o2.length());
        });

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < splitExp.length; i++) {
            String[] split = splitExp[i].split(",");
            for (String s : split) {
                Integer val = Integer.parseInt(s);
                if (!set.contains(val)) {
                    res[i] = val;
                    set.add(val);
                    break;
                }
            }
        }
    }

    private void initRes(int size) {
        res = new int[size];
    }

    public int[] solution(String s) {
        this.expression = s;
        parseExpression();
        return res;
    }
}
