package kakao;

import java.util.*;

public class Ka18_1 {
    private boolean[] interSectionCheck;

    private List<String> makeSubset(String str) {
        List<String> subset = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i + 2);
            if(!isDigit(substring))
                continue;
            subset.add(substring);
        }

        return subset;
    }

    private boolean isDigit(String str) {
        for (int i = 0; i <= 1; i++) {
            if(!Character.isLetter(str.charAt(i)))
                return false;
        }
        return true;
    }

    private int countInterSection(List<String> subset1, List<String> subset2) {
        int cnt = 0;
        interSectionCheck = new boolean[subset2.size()];
        for (int i = 0; i < subset1.size(); i++) {
            if(isInterSection(subset2, subset1.get(i)))
                cnt++;
        }

        return cnt;
    }

    private int countSet(List<String> subset1, List<String> subset2) {
        return subset1.size() + subset2.size() ;
    }

    private boolean isInterSection(List<String> subset, String compVal) {
        for (int i = 0; i < subset.size(); i++) {
            if(subset.get(i).equals(compVal) && !interSectionCheck[i]){
                interSectionCheck[i] = true;
                return true;
            }
        }
        return false;
    }

    public int solution(String str1, String str2) {

        List<String> subset1 = makeSubset(str1.toLowerCase());
        List<String> subset2 = makeSubset(str2.toLowerCase());
        if (subset1.size() == 0 && subset2.size() == 0) {
            return 65536;
        }

        int numOfInterSection = countInterSection(subset1, subset2);
        int numOfUnion = countSet(subset1, subset2) - numOfInterSection;


        int answer = (int)(((double) numOfInterSection / numOfUnion) * 65536);
        return answer;
    }
}
