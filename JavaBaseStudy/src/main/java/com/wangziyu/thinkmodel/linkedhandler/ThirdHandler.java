package com.wangziyu.thinkmodel.linkedhandler;

public class ThirdHandler extends Handler{
    public ThirdHandler(Handler nextHandler, int id) {
        super(nextHandler, id);
    }

    public  void  concreHandle(){
        System.out.println("我是id:"+this.getId()+"执行");
    }
}
