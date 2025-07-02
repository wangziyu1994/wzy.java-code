package com.wangziyu.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class WzyGateWay2 extends ZuulFilter {
    /**
     * 指定过滤器类型  请求之前还是请求之后
     * **route：**过滤器可以处理实际的请求转发
     * post：在请求被转发之后，执行过滤器
     * error：在请求被转发时发生错误，执行过滤器
     * @return
     */
    @Override
    public String filterType() {
       // System.out.println("请求WzyGateWay2被路由之前的时候，调用");
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        System.out.println("wzygateway2开始判断路由结果为"+requestContext.get("isSuccess"));
        return (boolean) requestContext.get("isSuccess");
    }

    @Override
    public Object run() {
        System.out.println("wzygateway2开始判断路由");
        RequestContext requestContext=RequestContext.getCurrentContext();//获取请求上下文
        HttpServletRequest request = requestContext.getRequest();//获取请求对象
        System.out.println("请求形式是："+request.getMethod()+"请求url:"+request.getRequestURL().toString());
        String parameter1=request.getParameter("parameter1");
        System.out.println(parameter1);
        if(parameter1!=null&&parameter1.equals("wangziyu")){//对请求进行路由
            requestContext.setSendZuulResponse(true);//对请求进行路由
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess","true");


        }
        else{//不对请求进行路由
            requestContext.setSendZuulResponse(false);//不对请求进行路由
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("parameter1 is not true");
            requestContext.set("isSuccess","false");
        }

        return null;
    }
}
