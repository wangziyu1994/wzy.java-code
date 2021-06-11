package com.wangziyu.linuxiostudy.pagecachestudy;

import java.io.*;

public class PageCacheTest {
    public static final String  dirPath="";
    public static final String  fileName="output";
    public static final String  filePath=dirPath+fileName;
    public static final String writeBody="1234567890\n";

    public static void main(String[] args) throws IOException {
        String args0="1";
        if(args.length>0){
            args0=args[0];
        }
        File f=new File(PageCacheTest.filePath);
        if(f.exists()){
            System.out.println("上次文件存在,删除");
            f.delete();
        }
     switch (args0){
         case "0":
             noBufferedIoOutPut();
             break;
         case "1":
             bufferedIoOutPut();
             break;
         default:
             break;
     }
    }

    public static void noBufferedIoOutPut() throws IOException {
        byte[]  writeBody=PageCacheTest.writeBody.getBytes();
        File file=new File(PageCacheTest.filePath);
        FileOutputStream outputStream=new FileOutputStream(file);
        while (true) {
            outputStream.write(writeBody);
        }
    }


    public static void bufferedIoOutPut() throws IOException {
        byte[]  writeBody=PageCacheTest.writeBody.getBytes();
        File file=new File(PageCacheTest.filePath);
        FileOutputStream outputStream=new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
        while (true) {
            bufferedOutputStream.write(writeBody);
        }
    }

}
