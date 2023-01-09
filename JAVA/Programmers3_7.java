package programmers;

public class Programmers3_7 {
    class Solution {
        private int[] answer;
        private long[] numbers;
        private String binary;

        public int[] solution(long[] numbers) {
            answer = new int[numbers.length];
            this.numbers = numbers;
            makeAnswer();
            return answer;
        }

        private void makeAnswer() {
            for(int i = 0; i < answer.length; i++) {
                binary = makeBinary(numbers[i]);
                answer[i] = isBinaryTree() ? 1 : 0;
            }
        }

        private String makeBinary(long number) {
            StringBuilder sb = new StringBuilder();
            while(number > 0) {
                sb.insert(0, number % 2);
                number /= 2;
            }
            return sb.toString();
        }

        private boolean isBinaryTree() {
            int len = binary.length();
            int depth = makeDepth(len);

            return validateBinaryTree(depth, binary.length() / 2);
        }

        private int makeDepth(int length) {
            int depth = 1;
            int value = 1;
            while(value < length) {
                value += Math.pow(2, depth);
                depth++;
            }
            syncBinary(value);
            return depth - 1;
        }

        private boolean validateBinaryTree(int depth, int parent) {
            if(depth == 0) {
                return true;
            }

            int parentNum = binary.charAt(parent) - '0';
            int childDepth = (int) Math.pow(2, depth - 1);
            int node1 = binary.charAt(parent + childDepth) - '0';
            int node2 = binary.charAt(parent - childDepth) - '0';

            if(parentNum != 1) {
                if(node1 == 1 || node2 == 1)
                    return false;
            }

            return validateBinaryTree(depth - 1, parent + childDepth) && validateBinaryTree(depth - 1, parent - childDepth);
        }

        private void syncBinary(int value) {
            StringBuilder sb = new StringBuilder(binary);
            while(value != sb.length()) {
                sb.insert(0, 0);
            }
            binary = sb.toString();
        }


    }
}
