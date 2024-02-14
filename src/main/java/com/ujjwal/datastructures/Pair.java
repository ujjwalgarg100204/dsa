package com.ujjwal.datastructures;

/**
 * Pair
 */
public class Pair<K, V> {
    private K first;
    private V sec;

    public Pair() {
    }

    public Pair(K first, V sec) {
        this.first = first;
        this.sec = sec;
    }

    public K getFirst() {
        return first;
    }

    public V getSec() {
        return sec;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSec(V sec) {
        this.sec = sec;
    }
}
