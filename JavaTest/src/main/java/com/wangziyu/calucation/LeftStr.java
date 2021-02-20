package com.wangziyu.calucation;

public class LeftStr {
    public static void main(String[] args) {
        String str=getStr("abcdefgh",2);
        System.out.println(str);
    }

    public static String getStr(String str,int n){
        return str.substring(n,str.length())+str.substring(0,n);
    }
}
