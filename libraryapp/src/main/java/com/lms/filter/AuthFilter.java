package com.lms.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        
        String url = httpServletRequest.getRequestURI();
        HttpSession session = httpServletRequest.getSession(false); // Safety improvement: false ensures we don't accidentally create an empty session
        
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean allowedUrl = url.equals(httpServletRequest.getContextPath() + "/") ||
                url.equals(httpServletRequest.getContextPath() + "/AuthenticationController");
        
        if (loggedIn || allowedUrl) {
            chain.doFilter(request, response);
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}