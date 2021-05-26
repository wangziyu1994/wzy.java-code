package com.wangziyu.collectionstudy.wzylinkedlist;

public class Node {
    private Node pre;
    private Object self;
    private Node next;

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Object getSelf() {
        return self;
    }

    public void setSelf(Object self) {
        this.self = self;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
