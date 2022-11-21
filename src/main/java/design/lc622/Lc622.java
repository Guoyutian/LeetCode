package design.lc622;

public class Lc622 {
    private int[] data;
    private int currentSize;
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public Lc622(int k) {
        data = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull() == false) {
            data[rear] = value;
            rear = (rear + 1) % data.length;
            currentSize++;
            return true;
        }
        return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if ((isEmpty() == false)) {
            currentSize--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return isEmpty() ? -1 : data[(rear - currentSize + data.length) % data.length];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return isEmpty() ? -1 : data[(rear + data.length - 1) % data.length];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return currentSize == data.length;
    }
}
