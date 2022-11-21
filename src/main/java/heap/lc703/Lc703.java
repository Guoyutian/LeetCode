package heap.lc703;

import java.util.PriorityQueue;

public class Lc703 {
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public Lc703(int k, int[] nums) {
        this.k = k;
        for (Integer i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
