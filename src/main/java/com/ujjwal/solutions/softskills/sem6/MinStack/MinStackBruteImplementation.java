package com.ujjwal.solutions.softskills.sem6.MinStack;

import java.util.LinkedList;
import java.util.List;

import com.ujjwal.datastructures.Pair;

/**
 * MinStackBruteImplementation
 */
public class MinStackBruteImplementation implements MinStack {
    private List<Pair<Integer, Integer>> list = new LinkedList<>();

    @Override
    public void push(int val) {
        if (this.list.isEmpty()) {
            this.list.add(new Pair<>(val, val));
        } else {
            Pair<Integer, Integer> top = list.getLast();
            this.list.add(new Pair<>(val, Math.min(top.getSec(), val)));
        }
    }

    @Override
    public void pop() {
        this.list.removeLast();
    }

    @Override
    public int top() {
        return list.getLast().getFirst();
    }

    @Override
    public int getMin() {
        return list.getLast().getSec();
    }

}
