package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class Ka18_2 {
    private int cacheSize;
    private String[] cities;
    private int executeTime = 0;
    private Queue<String> cache = new LinkedList<>();

    private void executeCache() {
        for (String city : cities) {
            cacheInsert(city.toLowerCase());
        }
    }

    private void cacheInsert(String city) {
        if (isHit(city)) {
            cacheHitInsert(city);
        }else{
            cacheMissInsert(city);
        }
    }

    private void cacheHitInsert(String city) {
        cache.remove(city);
        cache.add(city);
        executeCacheHit();
    }

    private void cacheMissInsert(String city) {
        if (isFull()) {
            cache.poll();
        }
        if(cacheSize != 0)
            cache.add(city);
        executeCacheMiss();
    }

    private boolean isFull() {
        if(cache.size() == cacheSize)
            return true;
        return false;
    }

    private boolean isHit(String city) {
        return cache.stream().anyMatch(c -> c.equals(city));
    }

    private void executeCacheHit() {
        executeTime++;
    }

    private void executeCacheMiss() {
        executeTime += 5;
    }

    public int solution(int cacheSize, String[] cities) {
        this.cacheSize = cacheSize;
        this.cities = cities;
        executeCache();
        return executeTime;
    }
}
