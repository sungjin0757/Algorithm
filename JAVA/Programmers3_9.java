package programmers;
import java.util.*;

public class Programmers3_9 {
    class Solution {
        private List<String> answerTemp = new ArrayList<>();
        private Point[][] union = new Point[51][51];
        private String[] answer;

        public String[] solution(String[] commands) {
            init();
            for(String command : commands) {
                doCommand(command);
            }
            makeAnswer();
            return answer;
        }


        private void init() {
            for(int i = 0; i <= 50; i++) {
                for(int j = 0 ; j <= 50; j++) {
                    union[i][j] = new Point(i, j);
                }
            }
        }

        private void makeAnswer() {
            answer = new String[answerTemp.size()];
            for(int i = 0 ; i < answerTemp.size(); i++) {
                answer[i] = answerTemp.get(i);
            }
        }

        private void doCommand(String command) {
            String[] commandArray = command.split(" ");
            String mainCommand = commandArray[0];
            if(mainCommand.equals("UPDATE")) {
                update(commandArray);
            } else if(mainCommand.equals("MERGE")) {
                merge(commandArray);
            } else if(mainCommand.equals("UNMERGE")) {
                unMerge(commandArray);
            } else if(mainCommand.equals("PRINT")) {
                print(commandArray);
            }
        }

        private void update(String[] command) {
            int size = command.length;
            if(size == 4) {
                cellUpdate(command);
            } else if(size == 3) {
                valueUpdate(command);
            }
        }

        private void cellUpdate(String[] command) {
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);
            Point point = find(new Point(row, col));
            int compRow = point.row;
            int compCol = point.col;
            for(int i =1; i<=50;i++) {
                for(int j = 1; j <= 50; j++) {
                    Point p = find(union[i][j]);
                    if(p.row == compRow && p.col == compCol) {
                        union[i][j].value = command[3];
                    }
                }
            }
        }

        private void valueUpdate(String[] command) {
            for(int i = 0; i <= 50; i++) {
                for(int j = 0 ; j <= 50; j++) {
                    Point point = find(union[i][j]);
                    if(point.value.equals(command[1])) {
                        union[i][j].value = command[2];
                    }
                }
            }
        }

        private void merge(String[] command) {
            int row1 = Integer.parseInt(command[1]);
            int col1 = Integer.parseInt(command[2]);
            int row2 = Integer.parseInt(command[3]);
            int col2 = Integer.parseInt(command[4]);

            Point n1 = find(union[row1][col1]);
            Point n2 = find(union[row2][col2]);
            if((n1.row == n2.row) && (n1.col == n2.col))
                return;
            if(n1.value.equals("EMPTY") && !n2.value.equals("EMPTY")) {
                union[row1][col1].row = n2.row;
                union[row1][col1].col = n2.col;
                union[row1][col1].value = n2.value;
            } else {
                union[row2][col2].row = n1.row;
                union[row2][col2].col = n1.col;
                union[row2][col2].value = n1.value;
            }

        }

        private void unMerge(String[] command) {
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);

            Point compPoint = union[row][col];
            int compRow = compPoint.row;
            int compCol = compPoint.col;
            for(int i = 0; i <= 50; i++) {
                for(int j = 0 ; j <= 50; j++) {
                    Point point = union[i][j];
                    if(point.row == compRow && point.col == compCol) {
                        union[i][j].row = i;
                        union[i][j].col = j;
                        if(row != i || col != j)
                            union[i][j].value = "EMPTY";
                    }
                }
            }

        }

        private void print(String[] command) {
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);
            Point point = union[row][col];
            answerTemp.add(point.value);
        }

        private Point find(Point point) {
            int row = point.row;
            int col = point.col;
            Point unionPoint = union[row][col];
            int unionRow = unionPoint.row;
            int unionCol = unionPoint.col;
            if((row == unionRow) && (col == unionCol)) {
                return unionPoint;
            }
            Point p = find(union[row][col]);
            union[row][col].row = p.row;
            union[row][col].col = p.col;
            union[row][col].value = p.value;

            return union[row][col];
        }

        private class Point {
            int row;
            int col;
            String value;

            public Point(int row, int col) {
                this.row = row;
                this.col = col;
                this.value = "EMPTY";
            }
        }
    }
}
