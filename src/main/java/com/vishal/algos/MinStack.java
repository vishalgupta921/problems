package com.vishal.algos;

import java.util.Stack;

public class MinStack {

    Long minimum = 0l;
    /**
     * We can also use Node class instead of stack
     * class Node {
     *     private int val;
     *     private int min;
     *     private Node next;
     *     Node(int val, int min) {
     *         this.val = val;
     *         this.min = min;
     *     }
     *
     *     Node(int val, int min, Node next) {
     *          this.val = val;
     *          this.min = min;
     *          this.next = next;
     *     }
     *
     *     node = new Node(x, Math.min(x, node.min), node)
     *
     * }
     */
    Stack<Long> stack = null;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Long y = (long) x;
        if(stack.isEmpty()) {
            stack.push(y);
            minimum = y;
            return;
        }
        if(y < minimum) {
            /**
             * (2*val - minimum) always less than new minimum
             *  by this we always kept first minimum value with new in stack
             *
             */
            stack.push(2*y- minimum);
            minimum = y;
        }else
            stack.push(y);
    }

    public void pop() {
        Long top = stack.pop();
        if(top < minimum) {
            /**
             * (2*minimum - top) used to retrieve the last minimum value
             *  adding by formula (2*val - minimum)
             *
             */
            minimum = 2*minimum - top;
        }
    }

    public int top() {
        Long top = stack.peek();
        return top < minimum ? minimum.intValue() : top.intValue();
    }

    public int getMin() {
        return minimum.intValue();
    }
}
