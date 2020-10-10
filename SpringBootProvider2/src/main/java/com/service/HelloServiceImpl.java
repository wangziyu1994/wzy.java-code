package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
    private static Logger logger = LoggerFactory.getLogger("HelloServiceImpl.class");

    private static Logger wzylogger = LoggerFactory.getLogger("wzylogger");


    @Override
    public void doHelloService() {

        logger.info("进入HelloServiceImpl方法");
        logger.debug("debug-doHelloService1方法");
        logger.error("error-doHelloService2方法");
        logger.warn("warn-doHelloService1方法");
        logger.trace("trace-doHelloService2方法");

        wzylogger.debug("wzylogger的debug日志");

    }
}
