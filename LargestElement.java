package Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestElement {
    public int solve(int[] nums,int k){
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k];
    }

    public int solve_pq(int[] nums,int k){
        Queue<Integer> pq=new PriorityQueue<>();

        for(int i:nums){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();

    }
}
