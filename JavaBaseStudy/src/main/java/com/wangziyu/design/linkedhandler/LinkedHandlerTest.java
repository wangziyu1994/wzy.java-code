package com.wangziyu.design.linkedhandler;

public class LinkedHandlerTest {
    public static void main(String[] args) {
        Handler fourHandler=new ForthHandler(null,4);
        Handler thirdHandler=new ThirdHandler(fourHandler,3);
        Handler secondHandler=new SecondHandler(thirdHandler,2);
        Handler firstHandler=new FirstHandler(secondHandler,1);

        firstHandler.descision(new Request(4));
        int count1=0;
        System.out.println(count1++);
        System.out.println(count1);

        int count2=0;
        System.out.println(++count2);
        System.out.println(count2);
    }
}
