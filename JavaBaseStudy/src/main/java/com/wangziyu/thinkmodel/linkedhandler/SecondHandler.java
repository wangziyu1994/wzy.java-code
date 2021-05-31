package com.wangziyu.thinkmodel.linkedhandler;

public class SecondHandler extends Handler{
    public SecondHandler(Handler nextHandler, int id) {
        super(nextHandler, id);
    }

    public  void  concreHandle(){
        System.out.println("我是id:"+this.getId()+"执行");
    }
}
