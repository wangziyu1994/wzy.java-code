package com.wangziyu.collectionstudy.wzylinkedlist;

public class WzyLinkedListTest {
    public static void main(String[] args) {
        WzyLinkedList wzyLinkedList=new WzyLinkedList();
        wzyLinkedList.add("a");
        wzyLinkedList.add("b");
        wzyLinkedList.add("c");
        wzyLinkedList.add("d");

        System.out.println(wzyLinkedList.getSize());
        System.out.println(wzyLinkedList.get(0));
        System.out.println(wzyLinkedList.get(1));
        System.out.println(wzyLinkedList.get(2));
        System.out.println(wzyLinkedList.get(3));
    }
}
