package sort.lc692;

import java.util.*;

public class Lc692 {
    public class Node{
        String word;
        int freq;
        int order;
        public Node(String word, int freq,int order) {
            this.word = word;
            this.freq = freq;
            this.order = order;
        }
        public String getWord() {
            return word;
        }
        public int getFreq() {
            return freq;
        }

        public int getOrder() {
            return order;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(); // 统计频次
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Node> values = new ArrayList<>(); // 将频次存入ArrayList<>
        int order = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int freq = entry.getValue();
            values.add(new Node(key,freq,order++));
        }

        String[] ans = new String[k];
        quickSelect(values, 0, values.size() - 1, ans, 0, k);
        return Arrays.asList(ans);

    }

    private void quickSelect(List<Node> values, int start, int end, String[] ans, int ansIndex, int k) {
        int pivotIndex = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, start, pivotIndex); // 将pivot和start交换

        int pivotValue = values.get(start).getFreq();
        int index = start; // 初始化大于等于pivot的元素应该在的下标

        for (int i = start + 1; i <= end; i++) {
            if (values.get(i).getFreq() >= pivotValue) { // 比pivot大的在左边，小的在右边
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index); // 将pivot放到应该在的位置

        if (index - start >= k) { // 当pivot包含的多余k个时，虽然此时左边都比pivot的大，左区间仍是乱序的，对于k而言相当于没排序
            quickSelect(values, start, index - 1, ans, ansIndex, k); // 缩小范围，向左
        } else { // 当pivot包含元素小于k时，起码pivot左边的都大于pivot，因此pivot左边的也大于k，这些数字可以放入结果中
            for (int i = start; i <= index; i++) {
                ans[ansIndex] = values.get(i).getWord();
                ansIndex++;
            }
            if (index - start + 1 < k) { // 当pivot和起点间的个数小于k时，则从pivot到end再继续找剩下的前（k - （pivot - start + 1））大的元素
                quickSelect(values, index + 1, end, ans, ansIndex, k - (index - start + 1));
            }
        }
    }
}
