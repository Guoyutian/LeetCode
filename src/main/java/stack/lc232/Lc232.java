package stack.lc232;

import java.util.Stack;

public class Lc232 {
    class MyQueue {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();

        // Push element x to the back of queue.
        public void push(int x) {
            pushStack.push(x);
        }

        // Removes the element from in front of queue.
        public int pop() {
            if(popStack.isEmpty()) {
                while(!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        // Get the front element.
        public int peek() {
            if(popStack.isEmpty()) {
                while(!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }
}
