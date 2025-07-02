package com.wangziyu.algorithmic.linkedliststudy;

public class WzyQueue<V> {
    public WzyNode<V> head;
    public WzyNode<V> tail;
    public int size;

    public WzyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void offer(V value){
     WzyNode<V> newNode=new WzyNode<>(value);
     if(head==null){
         head=newNode;
         tail=newNode;
     }
     else{
         tail.next=newNode;
         tail=newNode;
     }

     size++;
    }


    public WzyNode<V> poll(){
        WzyNode<V> targetNode=null;
        if(head!=null) {
            targetNode=head;
            head = head.next;
        }
        if(head==null){
            tail=null;
        }
        size--;
        return targetNode;
    }

    public WzyNode<V> peek(){
       return head;
    }


}
