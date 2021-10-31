package com.wangziyu.test;

import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyTest {
    @Test
    public void test1() {
        int a = getFisrtUniq1("abcdefg");
        //char a='';
        System.out.println(a);
        String s = "sdfdsfd";
        String[] str = s.split("");
        System.out.println(Arrays.toString(str));
        System.out.println(strSort("abcdefg"));
        System.out.println("".hashCode());
        System.out.println(System.currentTimeMillis());

        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);

        LocalDateTime localDateTime = LocalDateTime.now().plusYears(5000);
        Long milliSecond2 = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(localDateTime);
        System.out.println(milliSecond2);
    }


    public int getFisrtUniq(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        for (int i = 0; i <= stringBuffer.length() - 1; i = 0) {
            char var = stringBuffer.charAt(i);
            if (stringBuffer.length() == 1) {
                return s.indexOf(var);
            }
            stringBuffer.deleteCharAt(i);
            char[] interChar = new char[1];
            interChar[0] = var;
            String str = new String(interChar);
            int isUniq = stringBuffer.indexOf(str);
            if (isUniq == -1) {
                return s.indexOf(var);
            }
            String var2 = s.replaceAll(str, "");
            stringBuffer = new StringBuffer(var2);
        }
        return -1;
    }

    public int getFisrtUniq1(String s) {

        String[] strArray = s.split("");
        if (strArray.length == 0) {
            return -1;
        }
        for (int i = 0; i <= strArray.length - 1; i++) {
            int first = s.indexOf(strArray[i]);
            int last = s.lastIndexOf(strArray[i]);
            if (first == last) {
                return first;
            }
        }
        return -1;

    }


    public String strSort(String s) {
        char[] charArray = s.toCharArray();
        char[] newCharArray = new char[charArray.length];
        int[] intArray = new int[charArray.length];
        int[] newIntArray = new int[charArray.length];
        for (int i = 0; i <= charArray.length - 1; i++) {
            intArray[i] = charArray[i];
        }
        Arrays.sort(intArray);
        for (int i = 0; i <= charArray.length - 1; i++) {
            newIntArray[i] = intArray[charArray.length - i - 1];
        }

        for (int i = 0; i <= charArray.length - 1; i++) {
            newCharArray[i] = (char) intArray[i];
        }
        return new String(newCharArray);
    }


    @Test
    public void test2() {
        System.out.println(0 / 2);
        System.out.println(1 / 2);
        System.out.println(3 / 2);
        System.out.println(5 / 2);
    }


    @Test
    public void test3() {
        LocalDate localDate = LocalDate.of(2021, 2, 28);
        // localDate.
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        Month month1 = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(month1);
        System.out.println(day);
        System.out.println(Integer.valueOf("10"));
    }


    @Test
    public void testRe() {
        String str = reverseWords("Let's take LeetCode contest");
        System.out.println(str);
    }


    public String reverseWords(String s) {
        String[] strr = s.split(" ");
        System.out.println(Arrays.toString(strr));
        StringBuffer strb = new StringBuffer();
        for (int i = 0; i < strr.length; i++) {
            char[] charArr = strr[i].toCharArray();
            reverseArr(charArr);
            System.out.println(Arrays.toString(charArr));
            strb.append(new String(charArr) + " ");
        }
        System.out.println(Arrays.toString(strr));
        strb.deleteCharAt(strb.length() - 1);
        return strb.toString();
    }


    public void reverseArr(char[] charArr) {
        int Len = charArr.length;
        int L = 0;
        int R = Len - 1;
        while (L < R) {
            char temp = charArr[L];
            charArr[L] = charArr[R];
            charArr[R] = temp;
            L++;
            R--;
        }
    }

    public void swapValue(char value1, char value2) {
        char temp = value1;
        value1 = value2;
        value2 = temp;
    }


    @Test
    public void testIntegerSect() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
       Map<Integer,Integer> hashMap=new HashMap();
       for(int i:nums1){
           int count=hashMap.getOrDefault(i,0)+1;
           hashMap.put(i,count);
       }

       List<Integer> list=new ArrayList<>();
        for(int i:nums2){
           if(hashMap.containsKey(i)){
               list.add(i);
           }
        }
       Integer[] integers=   new Integer[list.size()];
       list.toArray(integers);
        return Arrays.stream(integers).mapToInt((Integer i)->{
            return i.intValue();
        }).toArray();
    }

    @Test
    public void testmaxProfit() {
        int[] nums1 = {7,1,5,3,6,4};
        int res = maxProfit(nums1);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int maxProfile=0;
        int index=0;
         for(int i=0;i<prices.length-1;i++){
             for(int j=i+1;j<prices.length;j++){
                 int newProfile=prices[j]-prices[i];
                 if(newProfile>maxProfile){
                     maxProfile=newProfile;
                     index=i;
                 }
             }
         }
      System.out.println(maxProfile);
        System.out.println(index);
         return index+1;
    }



    @Test
    public  void test() throws ClassNotFoundException, SQLException {
        Integer integer=10;
        String s="saber";
        updateInteger(integer);
        updateString(s);
        System.out.println(integer);
        System.out.println(s);

        Class.forName("");
        DriverManager.getConnection("");
    }


    public void updateString(String param){
        param="updatestr";
    }

    public void updateInteger(Integer param){
      param=9999;
    }


    /**
     * 测试 hashSet 元素 唯一性
     */
    @Test
    public void testHashSet(){
        HashSet<Long> ackSet=new HashSet<>();
        ackSet.add(1L);
        ackSet.add(1L);
        ackSet.add(1L);
        ackSet.add(1L);
        ackSet.add(1L);
        System.out.println(ackSet.size());
    }



    @Test
    public void test10(){
      String a="c";
      System.out.println("start");
      switch (a){
          case "a":
              System.out.println(a);
              break;
          case "b":
              System.out.println(a);
              break;
          default:
              System.out.println("default");
              break;
      }
    }


    @Test
    public void test11() throws Exception {
      Map<String,String> map=new HashMap();
      System.out.println(map.get(null));
       boolean a=false;
       if(a){
           System.out.println("true");
       }
       Class.forName("");
       DriverManager.getConnection("");

    }

}
