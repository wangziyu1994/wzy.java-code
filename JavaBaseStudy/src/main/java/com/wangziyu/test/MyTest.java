package com.wangziyu.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MyTest {
    @Test
    public void test1(){
        int a=getFisrtUniq1("abcdefg");
        //char a='';
        System.out.println(a);
        String s="sdfdsfd";
        String[] str=s.split("");
        System.out.println(Arrays.toString(str));
        System.out.println(strSort("abcdefg"));
    }


    public int getFisrtUniq(String s){
        StringBuffer stringBuffer=new StringBuffer(s);
        for(int i=0;i<=stringBuffer.length()-1;i=0){
            char var= stringBuffer.charAt(i);
            if(stringBuffer.length()==1){
                return s.indexOf(var);
            }
            stringBuffer.deleteCharAt(i);
            char[] interChar=new char[1];
            interChar[0]=var;
            String str=new String(interChar);
            int isUniq=stringBuffer.indexOf(str);
            if(isUniq==-1){
                return s.indexOf(var);
            }
            String var2=s.replaceAll(str,"");
            stringBuffer=new StringBuffer(var2);
        }
        return -1;
    }

    public int getFisrtUniq1(String s){

       String[] strArray=s.split("");
       if(strArray.length==0){
           return -1;
       }
        for(int i=0;i<=strArray.length-1;i++){
           int first= s.indexOf(strArray[i]);
           int last=s.lastIndexOf(strArray[i]);
           if(first==last){
               return first;
           }
       }
        return -1;

    }


    public String strSort(String s){
        char[] charArray=s.toCharArray();
        char[] newCharArray=new char[charArray.length];
        int[] intArray=new int[charArray.length];
        int[] newIntArray=new int[charArray.length];
        for(int i=0;i<=charArray.length-1;i++){
            intArray[i]=charArray[i];
        }
        Arrays.sort(intArray);
        for(int i=0;i<=charArray.length-1;i++){
            newIntArray[i]=intArray[charArray.length-i-1];
        }

        for(int i=0;i<=charArray.length-1;i++){
            newCharArray[i]=(char)intArray[i];
        }
        return new String(newCharArray);
    }
}
