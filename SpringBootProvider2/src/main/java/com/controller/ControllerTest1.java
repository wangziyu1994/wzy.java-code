package com.controller;

import com.alibaba.fastjson.JSON;
import com.model.School;
import com.model.Student;
import com.model.Subject;
import com.model.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="ControllerTest1")
public class ControllerTest1 {
    private static Logger logger = LoggerFactory.getLogger("ControllerTest1.class");

    @RequestMapping(value="/sayhellotest",method = RequestMethod.POST,consumes = "application/xml;charset=UTF-8",produces = "application/xml;charset=UTF-8")
    @ApiOperation(value="sayhello")
    public @ResponseBody
    Student sayHello(@RequestBody Student student) {
        System.out.println("请求student的对象是:"+student.toString());
        Student student1=new Student();
        Subject subject=new Subject();
        student1.setClassName("dfdsf");
        student1.setCommentHead("dfsdf");
        subject.setScores("90");
        student1.setSubject(subject);

        /*
         * try { int i=9/0; } catch(ArithmeticException ae) { logger.error("日志记录算术异常");
         * } int i=0; while(i<200) { logger.trace("trace日志记录开始");
         * logger.debug("debug日志记录开始"); logger.info("info日志记录开始");
         * logger.warn("warn日志记录开始"); logger.error("error日志记录开始"); i++; }
         */
        //List<HelloUser>  lh=hd.selectHello();
        return student1;
    }

    @RequestMapping(value="/sayhellotestjson",method = RequestMethod.POST)
    public @ResponseBody
    School sayHelloJson(@RequestBody School school) {
        System.out.println("school:"+school.toString());
        School school1=new School();
        Teacher teacher=new Teacher();
        school1.setSchoolName("dfdsf");
        teacher.settId("dfsdf");
        teacher.settName("ddd");
        school1.setTeacher(teacher);

        /*
         * try { int i=9/0; } catch(ArithmeticException ae) { logger.error("日志记录算术异常");
         * } int i=0; while(i<200) { logger.trace("trace日志记录开始");
         * logger.debug("debug日志记录开始"); logger.info("info日志记录开始");
         * logger.warn("warn日志记录开始"); logger.error("error日志记录开始"); i++; }
         */
        //List<HelloUser>  lh=hd.selectHello();
        String json= JSON.toJSONString(school1);
        System.out.println("json:"+json);
        return school1;
    }

}
