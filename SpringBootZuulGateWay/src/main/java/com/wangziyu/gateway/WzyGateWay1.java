package com.wangziyu.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;


//ZuulFilter  zuul核心组件，可以自定义网关转发方式
public class WzyGateWay1 extends ZuulFilter {


    /**
     * 指定过滤器类型  请求之前还是请求之后
     * pre：在请求被转发之前，执行过滤器
     * **route：**过滤器可以处理实际的请求转发
     * post：在请求被转发之后，执行过滤器
     * error：在请求被转发时发生错误，执行过滤器
     * @return
     */
    @Override
    public String filterType() {
        //System.out.println("请求WzyGateway1被路由之前的时候，调用");
        return "pre";
    }

    /*
    filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        System.out.println("指定执行顺序");
        return 0;
    }

    /**
     * 是否执行该过滤器，此处为true，说明需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     *自定义路由
     * @return
     */
    @Override
    public Object run() {
        System.out.println("wzygateway1开始判断路由");
        RequestContext requestContext=RequestContext.getCurrentContext();//获取请求上下文
        HttpServletRequest request = requestContext.getRequest();//获取请求对象
System.out.println("请求形式是："+request.getMethod()+"请求url:"+request.getRequestURL().toString());
        String isGateWayFlag=request.getParameter("gateway1");
        System.out.println(isGateWayFlag);
        if(isGateWayFlag!=null&&isGateWayFlag.equals("true")){//对请求进行路由
            requestContext.setSendZuulResponse(true);//对请求进行路由
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess",true);


        }
        else{//不对请求进行路由
            requestContext.setSendZuulResponse(false);//不对请求进行路由
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("not come in gateway1");
            requestContext.set("isSuccess",false);
        }


        return null;
    }
}
