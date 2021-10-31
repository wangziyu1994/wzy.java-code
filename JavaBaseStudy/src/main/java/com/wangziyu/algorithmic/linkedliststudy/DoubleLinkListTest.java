package com.wangziyu.algorithmic.linkedliststudy;

public class DoubleLinkListTest {
    public static void main(String[] args) {
       LinkListModel linkListModel=getDoubleLinkedList(50);
        printSequenceLinekedList(linkListModel.head);
       printReverseSequenceLinekedList(linkListModel.tail);

       reversedDoubleLinekedList(linkListModel.head);
        System.out.println("反转双向链表后");
        printSequenceLinekedList(linkListModel.tail);
        printReverseSequenceLinekedList(linkListModel.head);
    }



    public static LinkListModel getDoubleLinkedList(int size){
        LinkListModel list=new LinkListModel();
        DoubleNode head=null;
        DoubleNode tail=null;
        for(int i=0;i<size;i++){
            DoubleNode newNode=new DoubleNode(i);
            if(i==0){
                head=newNode;
                tail=newNode;
                continue;
            }
            if(head!=null){
                tail.next=newNode;
                newNode.pre=tail;
                tail=newNode;
            }

        }
        list.head=head;
        list.tail=tail;

        return list;
    }

 public static void printSequenceLinekedList(DoubleNode head){
     DoubleNode currentNode=head;
        while(currentNode!=null){
            System.out.print(currentNode.value+",");
            currentNode=currentNode.next;
        }
        System.out.println(currentNode);
    }


    public static void printReverseSequenceLinekedList(DoubleNode head){
        DoubleNode currentNode=head;
        while(currentNode!=null){
            System.out.print(currentNode.value+",");
            currentNode=currentNode.pre;
        }
        System.out.println(currentNode);
    }


    public static DoubleNode reversedDoubleLinekedList(DoubleNode head){
        DoubleNode currentNode=head;
           while(currentNode!=null){
               DoubleNode beforeNext=currentNode.next;
               DoubleNode beforePre=currentNode.pre;

               currentNode.next=beforePre;
               currentNode.pre=beforeNext;



               currentNode=beforeNext;
           }
           return currentNode;
    }
}
