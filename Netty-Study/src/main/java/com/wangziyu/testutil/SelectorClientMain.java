package com.wangziyu.testutil;

import java.io.IOException;

public class SelectorClientMain {
    public static final int port=1200;
    public static void main(String[] args) throws IOException {
        ClientSelectorGroup clientSelectorGroup=new ClientSelectorGroup(1);
        clientSelectorGroup.connect(port);
    }
}
