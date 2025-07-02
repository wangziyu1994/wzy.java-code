package com.wangziyu.collectionstudy.wzylinkedlist;

public class WzyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(Object o){
        if(head==null){
            Node node=new Node();
            node.setPre(null);
            node.setNext(null);
            node.setSelf(o);
            head=node;
            tail=node;
        }else{
            Node node=new Node();
            node.setSelf(o);
            node.setPre(tail);
            node.setNext(null);

            node.getPre().setNext(node);
            tail=node;
        }
        size++;
    }

    public int getSize(){
        return size;
    }

    public Object get(int index){
        Node  node=head;
        for(int i=0;i<index;i++){
           node=node.getNext();
        }

        return node.getSelf();
    }
}
