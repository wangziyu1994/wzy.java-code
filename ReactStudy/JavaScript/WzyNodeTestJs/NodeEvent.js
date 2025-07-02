//引入事件模块
var event=require("events");
//创建EventEmitter对象
var eventEmitter=new event.EventEmitter();

//创建事件处理程序
var eventHandler1=function(){
    console.log("我是事件处理程序");
}


//绑定事件以及事件处理程序
eventEmitter.on('myevent1',eventHandler1);
//触发事件
eventEmitter.emit("myevent1");



