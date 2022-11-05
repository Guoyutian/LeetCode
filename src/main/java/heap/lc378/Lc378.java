package heap.lc378;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lc378 {
    /*Approach 2 (Using Priority Queue) //By reading that we have to return kth of something,this approach usually comes into mind
    Time Complexity: N * log(K) //N== n^2
    Auxiliary Space Complexity: O(K)*/
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int n = matrix.length;
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    if(pq.size() < k){
                        pq.add(matrix[i][j]);
                    }else{ //equal to k
                        if(matrix[i][j] < pq.peek()){ //if incoming element is less than peek
                            pq.poll();
                            pq.add(matrix[i][j]);
                        }
                    }
                }
            }
            return pq.peek();
        }
}
