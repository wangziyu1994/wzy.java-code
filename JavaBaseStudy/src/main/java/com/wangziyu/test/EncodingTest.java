package com.wangziyu.test;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public class EncodingTest {
    @Test
    public void utf8Test() throws UnsupportedEncodingException {
        byte[] bytes={-29,-101,-125};
        Charset cs = Charset.forName("UTF-8");
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes);
        bb.flip();
        CharBuffer cb = cs.decode(bb);
        System.out.println(Arrays.toString(cb.array()));
        String st="㛃";
        String utf8="";
        utf8=new String(st.getBytes("UTF-8"));
        utf8=URLEncoder.encode(utf8,"UTF-8");
        System.out.println(utf8);
    }
}
