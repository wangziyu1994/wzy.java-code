package com.wangziyu.testutil;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        SelectorGroup selectorGroup=new SelectorGroup(3);
        selectorGroup.bind(1200);
    }
}
