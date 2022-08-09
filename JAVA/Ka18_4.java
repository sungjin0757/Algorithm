package kakao;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ka18_4 {
    private String res;
    private String[] musicinfos;
    private String startTime;
    private String endTime;
    private String title;
    private String scale;
    private String m;
    private PriorityQueue<Music> pq = new PriorityQueue<>(new Comparator<Music>() {
        @Override
        public int compare(Music o1, Music o2) {
            return Integer.compare(o1.playTime, o2.playTime);
        }
    });

    private void genRes() {
        if(pq.size() == 0)
            res = "(None)";
        else
            res = pq.peek().title;
    }

    private void addAnswerMusic() {
        for (String musicinfo : musicinfos) {
            initMusicInfo(musicinfo);
            addMusicInResTemp();
        }
    }

    private void initMusicInfo(String musicInfo) {
        String[] music = musicInfo.split(",");
        startTime = music[0];
        endTime = music[1];
        title = music[2];
        scale = music[3];
    }

    private int calPlayTime() {
        int startTimeInteger = parseTime(startTime);
        int endTimeInteger = parseTime(endTime);

        return endTimeInteger - startTimeInteger;
    }

    private int parseTime(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    private void addMusicInResTemp() {
        if (isAnswer()) {
            pq.offer(new Music(calPlayTime(), title));
        }
    }

    private boolean isAnswer() {
        if(m.length() > scale.length())
            return false;
        for (int i = 0; i < scale.length(); i++) {
            if(equalCharacter(m.charAt(0), scale.charAt(i)))
                return isScale(i);
        }
        return false;
    }

    private boolean isScale(int idx) {
        int i = 0;
        while (i < m.length()) {
            char mComp = m.charAt(i);
            char scaleComp = scale.charAt(idx % scale.length());
            if (mComp != scaleComp)
                return false;
            idx++;
            i++;
        }

        return true;
    }


    private boolean equalCharacter(char comp1, char comp2) {
        return comp1 == comp2;
    }

    public String solution(String m, String[] musicinfos) {
        this.m = m;
        this.musicinfos = musicinfos;
        addAnswerMusic();
        genRes();
        return res;
    }

    private class Music{
        private int playTime;
        private String title;

        public Music(int playTime, String title) {
            this.playTime = playTime;
            this.title = title;
        }
    }
}
