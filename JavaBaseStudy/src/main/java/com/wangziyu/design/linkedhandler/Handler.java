package com.wangziyu.design.linkedhandler;

public abstract class Handler {
    private Handler nextHandler;
    private int id;

    public Handler(Handler nextHandler, int id) {
        this.nextHandler = nextHandler;
        this.id = id;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void concreHandle();

    public final void descision(Request request){
        System.out.println("descision"+this.id+"判断开始");
        if(request.getValue()==this.id){
            System.out.println("handler"+this.id+"开始执行");
           this.concreHandle();
            System.out.println("handler"+this.id+"执行完成");
        }
        else{
            System.out.println("handler"+this.id+"无法执行");
            if(this.nextHandler==null){
               System.out.println("没有节点可以执行,执行链Finish!");
            }else {
                System.out.println("交由hander" + this.nextHandler.id + "执行");
                this.nextHandler.descision(request);
            }
        }
        System.out.println("descision"+this.id+"判断完成");
    }
}
