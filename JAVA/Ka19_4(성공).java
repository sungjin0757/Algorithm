package kakao;

class Ka19_44 {
    private int low = 1;
    private int high = 200000000;
    private int mid = 0;
    private int res = Integer.MIN_VALUE;

    private boolean checkCross(int[] stones, int k, int mid) {
        int cnt = 0;

        for (int stone : stones) {
            if (stone - mid < 0) {
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == k)
                return false;
        }
        return true;
    }

    private void process(int[] stones, int k) {
        while (low <= high) {
            mid = (low + high) / 2;

            if (!checkCross(stones, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
                res = Math.max(res, mid);
            }
        }
    }
    public int solution(int[] stones, int k) {
        process(stones, k);

        return res;
    }
}
