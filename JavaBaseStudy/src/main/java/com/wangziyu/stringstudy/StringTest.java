package com.wangziyu.stringstudy;

public class StringTest {
    public static void main(String[] args){
        String var1="abcd";
        int int1=100;
        String var4=new String("abcd");
        String var5=new String("abcd");
        String var2="efgh";
        //var1=var1+var2;
        var1+=var2;
        String var3=setString(var2);
        String result=setString(var4);
        System.out.println("var1:"+var1);
        System.out.println("var2:"+var2);
        System.out.println("source:"+var3);
        System.out.println("new string:"+var4);
        System.out.println(var1==var4);
        System.out.println(var4==var5);


        int intResult=setInt(int1);
        System.out.println(int1+"");
        System.out.println(intResult);
    }

    public static String setString(String source){
        source+="abcdefg";
        return  source;
    }

    public static int setInt(int source){
        source++;
        return  source;
    }
}
