package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jewel {

    public int solve(String jew, String stones) {
        Set<Character> set = new HashSet<>();
        int count=0;
        char[] jewCharacter = jew.toCharArray();
        for (char jewC : jewCharacter) {
            set.add(jewC);
        }
        char[] stoneC = stones.toCharArray();

        for(Character stone:stoneC){
            if(set.contains(stone)){
                count++;
            }
        }
        return count;
    }
}