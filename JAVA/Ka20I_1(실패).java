package kakao;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Ka20I_1 {
    private char[] ops;
    private int n;
    private char[] temp;
    private boolean[] check;
    private long res = Long.MIN_VALUE;

    private void dfs(int x, String expression) {
        if (x == n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if(check[i])
                continue;
            temp[x] = ops[i];
            dfs(x + 1, expression);
        }
    }

    private String genPostfix(String expression) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(!Character.isDigit(c)){

                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }


    private void genOp(String expression) {
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(Character.isDigit(c))
                continue;
            temp.add(c);
        }

        ops = new char[temp.size()];
        int idx = 0;
        for (Character op : temp) {
            ops[idx++] = op;
        }
    }

    public long solution(String expression) {
        long answer = 0;
        genOp(expression);
        this.n = ops.length;
        this.check = new boolean[n];
        return answer;
    }
}
