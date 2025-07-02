package com.wangziyu.algorithmic.linkedliststudy;

public class WzyNode<V> {
    public V value;
    public WzyNode<V> next;


    public WzyNode(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public WzyNode<V> getWzyNode() {
        return next;
    }

    public void setWzyNode(WzyNode<V> wzyNode) {
        this.next = wzyNode;
    }

    @Override
    public String toString() {
        return "WzyNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
