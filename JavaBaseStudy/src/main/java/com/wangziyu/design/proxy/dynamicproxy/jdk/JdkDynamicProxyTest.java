package com.wangziyu.design.proxy.dynamicproxy.jdk;



import com.wangziyu.design.proxy.MyInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InvocationHandler it=new MyInvocationInteceptor((o1,o2)->{
            System.out.println("执行目标方法");
            return "目标对象方法的返回值1";
        });
        Object proxyObject=Proxy.newProxyInstance(MyInterface.class.getClassLoader(),new Class[]{MyInterface.class},it);
        MyInterface proxyObject1=(MyInterface)proxyObject;
        String result=(String)proxyObject1.dosomething("1","a");
        System.out.println(result);


     /*   Class<?> proxyClass=Proxy.getProxyClass(MyInterface.class.getClassLoader(),MyInterface.class);
        Constructor<?> constructor=proxyClass.getConstructor(InvocationHandler.class);
        MyInterface proxyObject2=(MyInterface) constructor.newInstance(new MyInvocationInteceptor((o1,o2)->{
            return "目标对象方法的返回值2";
        }));
        String result1=(String) proxyObject2.dosomething("1","b");
        System.out.println(result1);
*/



    }
}
