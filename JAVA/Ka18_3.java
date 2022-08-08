package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ka18_3 {
    private String msg;
    private List<Integer> resTemp = new ArrayList<>();
    private Map<String, Integer> wordDictionary = new HashMap<>();
    private StringBuilder wordMaker = new StringBuilder();
    private int indexSize = 27;

    private void initWordDictionary() {
        for (int word = 1; word <= 26; word++) {
            wordDictionary.put(Character.toString(word + 64), word);
        }
    }

    private void addWord(String word) {
        String existWord = genExistWord(word);
        String existNotWord = genNotExistWord(word);

        resTemp.add(getIndexInWordDictionary(existWord));
        resTemp.add(getIndexInWordDictionary(existNotWord));

        wordDictionary.put(word, indexSize++);
    }

    private int getIndexInWordDictionary(String word) {
        return wordDictionary.get(word);
    }

    private String genExistWord(String word) {
        return word.substring(0, word.length() - 1);
    }

    private String genNotExistWord(String word) {
        return word.substring(word.length() - 1);
    }

    private void clearWordMaker() {
        wordMaker = new StringBuilder();
    }

    private void makeRes() {
        for (int i = 0; i < msg.length(); i++) {
            char word = msg.charAt(i);
            wordMaker.append(word);
            if(isExistInDictionary(wordMaker.toString()))
                continue;
            addWord(wordMaker.toString());
            clearWordMaker();
        }

    }

    private boolean isExistInDictionary(String word) {
        if(wordDictionary.containsKey(word))
            return true;
        return false;
    }

    public int[] solution(String msg) {
        this.msg = msg;
        initWordDictionary();
        makeRes();
        int[] res = new int[resTemp.size()];
        for (int i = 0; i < resTemp.size(); i++) {
            res[i] = resTemp.get(i);
        }

        return res;
    }
}
