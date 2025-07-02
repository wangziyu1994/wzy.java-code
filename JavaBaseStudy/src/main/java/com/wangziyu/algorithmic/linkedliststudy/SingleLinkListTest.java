package com.wangziyu.algorithmic.linkedliststudy;

public class SingleLinkListTest {
    public static void main(String[] args) {
       Node head=getLinkedList(50);
       printLinekedList(head);
       Node reverHead=reversedLinekedList(head);
       printLinekedList(reverHead);
    }



    public static Node getLinkedList(int size){
        Node pre=null;
        Node head=null;
        for(int i=0;i<size;i++){
            Node node=new Node(i);
            if(i==0){
                head=node;
            }
            if(pre!=null){
                pre.next=node;
            }
            node.next=null;
            pre=node;
        }

        return head;
    }

    public static void printLinekedList(Node head){
        Node currentNode=head;
        while(currentNode!=null){
            System.out.print(currentNode.value+",");
            currentNode=currentNode.next;
        }
        System.out.println(currentNode);
    }

    public static Node reversedLinekedList(Node head){
           Node currentNode=head;
           Node pre=null;
           while(currentNode!=null){
               Node beforeNext=currentNode.next;
               currentNode.next=pre;
               pre=currentNode;
               currentNode=beforeNext;
           }
           return pre;
    }
}
