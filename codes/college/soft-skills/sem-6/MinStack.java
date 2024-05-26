// Problem Link: https://leetcode.com/problems/min-stack/

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * MinStack
 */
public interface MinStack {

    void push(int val);

    void pop();

    int top();

    int getMin();

}

class BruteImplementationOfMinStack implements MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();

    @Override
    public void push(int val) {
        stack.push(val);
    }

    @Override
    public void pop() {
        stack.pop();
    }

    @Override
    public int top() {
        return stack.peek();
    }

    @Override
    public int getMin() {
        Deque<Integer> temp = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            min = Math.max(min, stack.peekLast());
            stack.push(stack.pop());
        }

        stack = new ArrayDeque<>(temp);
        return min;
    }

}

class PairImplementationOfMinStack implements MinStack {
    private class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }

    private Deque<Pair> stack = new ArrayDeque<>();

    @Override
    public void push(int val) {
        Pair stackNode = null;
        if (stack.isEmpty()) {
            stackNode = new Pair(val, val);
        } else {
            stackNode = new Pair(val, Math.min(val, stack.peek().second));
        }
        stack.push(stackNode);
    }

    @Override
    public void pop() {
        stack.pop();
    }

    @Override
    public int top() {
        return stack.peek().first;
    }

    @Override
    public int getMin() {
        return stack.peek().second;
    }

}

class OptimalImplementationOfMinStack implements MinStack {
    private int min;
    private Deque<Integer> stack = new ArrayDeque<>();

    @Override
    public void push(int val) {

    }

    @Override
    public void pop() {
    }

    @Override
    public int top() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'top'");
    }

    @Override
    public int getMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMin'");
    }

}
