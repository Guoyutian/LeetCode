package sort.lc_347;

import java.util.*;

class Lc347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // 统计频次
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>(); // 将频次存入ArrayList<>
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();
            values.add(new int[]{key, freq});
        }

        int[] ans = new int[k];
        quickSelect(values, 0, values.size() - 1, ans, 0, k);
        return  ans;

    }

    private void quickSelect(List<int[]> values, int start, int end, int[] ans, int ansIndex, int k) {
        int pivotIndex = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, start, pivotIndex); // 将pivot和start交换

        int pivotValue = values.get(start)[1];
        int index = start; // 初始化大于等于pivot的元素应该在的下标

        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivotValue) { // 比pivot大的在左边，小的在右边
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index); // 将pivot放到应该在的位置

        if (index - start >= k) { // 当pivot包含的多余k个时，虽然此时左边都比pivot的大，左区间仍是乱序的，对于k而言相当于没排序
            quickSelect(values, start, index - 1, ans, ansIndex, k); // 缩小范围，向左
        } else { // 当pivot包含元素小于k时，起码pivot左边的都大于pivot，因此pivot左边的也大于k，这些数字可以放入结果中
            for (int i = start; i <= index; i++) {
                ans[ansIndex] = values.get(i)[0];
                ansIndex++;
            }
            if (index - start + 1 < k) { // 当pivot和起点间的个数小于k时，则从pivot到end再继续找剩下的前（k - （pivot - start + 1））大的元素
                quickSelect(values, index + 1, end, ans, ansIndex, k - (index - start + 1));
            }
        }
    }

}