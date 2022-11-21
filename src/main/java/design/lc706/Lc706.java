package design.lc706;


public class Lc706 {
    class ListNode {
        int key, val;
        ListNode next;
        public ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    //No specific reason. For the size, I wanted something that was larger than the number of possible operations (10^4),
    // but as small as possible without risking too many collisions, and preferably prime.
    // The other is just a random large multiplier, also preferably a prime.
    static final int size = 19997;
    static final int mult = 12582917;
    ListNode[] data;

    public Lc706() {
        this.data = new ListNode[size];
    }

    private int hash(int key) {
        return (int) ((long) key * mult % size);
    }

    public void put(int key, int val) {
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key, val, data[h]);
        data[h] = node;
    }

    public int get(int key) {
        int h = hash(key);
        ListNode node = data[h];
        for (; node != null; node = node.next)
            if (node.key == key) return node.val;
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        ListNode node = data[h];
        if (node == null) return;
        if (node.key == key) data[h] = node.next;
        else for (; node.next != null; node = node.next)
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
    }
}
