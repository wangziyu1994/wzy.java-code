package com.wangziyu.thinkmodel.linkedhandler;

public class LinkedHandlerTest {
    public static void main(String[] args) {
        Handler fourHandler=new ForthHandler(null,4);
        Handler thirdHandler=new ThirdHandler(fourHandler,3);
        Handler secondHandler=new SecondHandler(thirdHandler,2);
        Handler firstHandler=new FirstHandler(secondHandler,1);

        firstHandler.descision(new Request(2));
    }
}
