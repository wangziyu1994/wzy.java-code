package com.wangziyu.calucation;

import com.wangziyu.calucation.model.ListNode;

import java.util.LinkedList;
import java.util.List;

public class DeleteMeduimNode {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(0);
        ListNode listNode2=new ListNode(1);
        ListNode listNode3=new ListNode(2);
        ListNode listNode4=new ListNode(3);
        ListNode listNode5=new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        System.out.println(listNode1.val+" "+listNode1.next.val+" "+listNode2.next.val+" "+listNode3.next.val+" "+listNode4.next.val);
        deleteMediumNode(listNode3);
        System.out.println(listNode1.val+" "+listNode1.next.val+" "+listNode2.next.val+" "+listNode3.next.val+" ");

    }
    public static void deleteMediumNode(ListNode listNode){
        listNode.val=listNode.next.val;
        listNode.next=listNode.next.next;
    }
}
