package com.wangziyu.algorithmic.linkedliststudy;

public class WzyStack<V> {
    public int size;
    public WzyNode<V> head;

    public WzyStack() {
        this.size = 0;
        this.head = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(WzyNode<V> newNode) {
        if (head == null) {
            head = newNode;
        } else {
            head.next = newNode;
        }
        size++;
    }

    public WzyNode<V> pop() {
        WzyNode<V> currentHead = head;
        if (head != null) {
            size--;
            head = head.next;
        }
        return currentHead;
    }

    public WzyNode<V> peek() {
        size--;
        return head;
    }

}
