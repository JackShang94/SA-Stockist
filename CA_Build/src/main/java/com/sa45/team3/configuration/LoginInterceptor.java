package com.sa45.team3.configuration;
import java.lang.reflect.Method;
import java.util.Map;
import com.sa45.team3.model.Staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
    	 String requestURI = request.getRequestURI();  
         if(requestURI.endsWith("login") || requestURI.endsWith("validate")){   
             
             return true;
         }else{  
        	 HttpSession session = request.getSession();  
             String role = (String) session.getAttribute("role");  
             if(role==null){   
            	request.getRequestDispatcher("/Authorize/login").forward(request, response);  
            	
             }else{   
                 //request.getRequestDispatcher("/login").forward(request, response);  
             }  
             return true;  
         }  
}  
    
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object arg2, Exception arg3)  
            throws Exception {  
    }  
  
    @Override  
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,  
            Object arg2, ModelAndView arg3) throws Exception {  
  
    }  
}
