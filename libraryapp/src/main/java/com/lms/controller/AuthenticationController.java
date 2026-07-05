package com.lms.controller;

import java.io.IOException;

import com.lms.pojo.User;
import com.lms.service.UserService;
import com.lms.serviceImpl.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/AuthenticationController")

public class AuthenticationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String action = req.getParameter("action");

        if("checkLogin".equalsIgnoreCase(action)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            UserService userService =  new UserServiceImpl(); // Polymorphism, coding to an interface
            User user = userService.checkLogin(username, password);
            if(user!=null){
                // req.setAttribute("successMessage", "Invalid username or password");
                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/dashboard.jsp");
                dispatcher.forward(req, resp);
            }
            else{
                req.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/login.jsp");
                dispatcher.forward(req, resp);
            }
        }
        else{
            System.out.print("No action found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        doGet(req, resp);
    }
    
}
