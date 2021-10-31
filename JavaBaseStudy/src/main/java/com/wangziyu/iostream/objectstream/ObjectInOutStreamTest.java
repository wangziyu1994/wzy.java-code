package com.wangziyu.iostream.objectstream;

import java.io.*;

public class ObjectInOutStreamTest {
    public static final String path="D:\\gitResposity-code\\JavaBaseStudy\\src\\main\\java\\com\\wangziyu\\iostream\\objectstream\\Person.txt";
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        writeObject();
        readObject();

    }


    public static void writeObject() throws IOException{
        File file=new File(path);
        if(file.exists()){
            file.delete();
        }
        Person person=new Person(1,"杨过");
        System.out.println(person);
        OutputStream outputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
        //添加脏的字节
        byte[] dirtybytes="abcd1234".getBytes();
        objectOutputStream.writeObject(dirtybytes);
        objectOutputStream.writeObject(person);
        //添加脏的字节
        byte[] dirtybytesAfter="adsfasfasfasdfasfsafdasf".getBytes();
        //objectOutputStream.writeObject(dirtybytesAfter);
        objectOutputStream.close();
        outputStream.close();
    }

    public static void readObject() throws IOException, ClassNotFoundException {
        File file=new File(path);
        InputStream inputStream=new FileInputStream(file);

      /*  byte[] all=new byte[2000];
        inputStream.read(all);
        int count=0;
        for(byte b:all){
            if(b!=0){
                count++;
            }
        }
        System.out.println(count);*/

       ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
        //com.wangziyu.iostream.objectstream.other.Person person=(com.wangziyu.iostream.objectstream.other.Person) objectInputStream.readObject();
        Person person=(Person) objectInputStream.readObject();
        System.out.println(person);
    }
}
