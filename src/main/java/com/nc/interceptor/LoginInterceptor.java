package com.nc.interceptor;
import java.util.Arrays;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nc.pojo.Category;
import com.nc.pojo.OrderItem;
import com.nc.pojo.User;
import com.nc.service.CategoryService;
import com.nc.service.OrderItemService;
  
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;
     /**
     * 在业务处理器处理请求之前被调�?
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再�??出拦截器�?
     * 如果返回true
     *    执行下一个拦截器,直到�?有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器�?回执行所有的postHandle()
     *    接着再从�?后一个拦截器�?回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
 
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
        String[] noNeedAuthPage = new String[]{
                "home",
                "checkLogin",
                "register",
                "loginAjax",
                "login",
                "product",
                "category",
                "search"};
 
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);
//        System.out.println(uri);
        if(uri.startsWith("/fore")){
            String method = StringUtils.substringAfterLast(uri,"/fore" );
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
                User user =(User) session.getAttribute("user");
                if(null==user){
                    response.sendRedirect("loginPage");
                    return false;
                }
            }
        }
 
        return true;
 
    }
  
    /**
     * 在业务处理器处理请求执行完成�?,生成视图之前执行的动�?
     * 可在modelAndView中加入数据，比如当前时间
     */
 
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,   
            ModelAndView modelAndView) throws Exception {
 
    }
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调�?,可用于清理资源等  
     *  
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */
      
    public void afterCompletion(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) 
    throws Exception { 
            
    } 
        
}