package com.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.lms.pojo.User;
import com.lms.service.UserService;
import com.lms.serviceImpl.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserController")

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        //System.out.println("action: " +action); // to see what is coming in action;

        if("showAddUser".equalsIgnoreCase(action)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addUser.jsp");
            dispatcher.forward(req, resp);
        }
        else if("addUser".equalsIgnoreCase(action)){
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String phoneNo = req.getParameter("phone");
            String address = req.getParameter("address");

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNo(phoneNo);
            user.setAddress(address);
            user.setRole("USER");

            String randomPass = UUID.randomUUID().toString().replace("-","").substring(0,8);
            user.setPassword(randomPass); // to remove flaw of adding user without password
            // which means any username with null password can login to portal

            user.setCreatedAt(new Date());

            UserService userService = new UserServiceImpl();
            boolean addFlag = userService.addUser(user);
            if(addFlag){
                List<User> userList = new ArrayList<>();

                userList = userService.getAllUserList();
                if(userList != null && userList.size()>0){
                    req.setAttribute("userList", userList);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/userList.jsp");
                    dispatcher.forward(req, resp);
                }
                else{
                    req.setAttribute("errorMessage", "Something went wrong");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addUser.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            else{
                req.setAttribute("errorMessage", "Something went wrong");
                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addUser.jsp");
                dispatcher.forward(req, resp);
            }
        }
        else if("allUserList".equalsIgnoreCase(action)){
            List<User> userList = new ArrayList<>();

            UserService userService = new UserServiceImpl();
            userList = userService.getAllUserList();

            if(userList != null && userList.size()>0){
                req.setAttribute("userList", userList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/userList.jsp");
                dispatcher.forward(req, resp);
            }
        }
        else if("viewUser".equalsIgnoreCase(action)) {
			String userId = req.getParameter("userId");
			
			UserService userService = new UserServiceImpl();
			User user = userService.getUserById(Long.parseLong(userId));
			
			if(user != null) {
				req.setAttribute("user", user);
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/editUser.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				List<User> userList = new ArrayList<User>();
				userList = userService.getAllUserList();
				
	        	if(userList != null && userList.size() > 0) {
	        		req.setAttribute("errorMessage", "User not found!!");
	        		req.setAttribute("userList", userList);
					RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/userList.jsp");
					dispatcher.forward(req, resp);
	        	}
			}
		}
		else if("updateUser".equalsIgnoreCase(action)) {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
	        String phoneNo = req.getParameter("phone"); 
	        String address = req.getParameter("address");
	        String email = req.getParameter("email");
	        long userId =Long.parseLong(req.getParameter("userId"));
	        
	        User user = new User();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setPhoneNo(phoneNo);
	        user.setAddress(address);
	        user.setEmail(email);
	        user.setUserId(userId);
	        
	        UserService userService = new UserServiceImpl();
	        boolean addFlag = userService.updateUser(user);
	        if(addFlag) {
	        	req.setAttribute("user", user);
	        	req.setAttribute("successMessage", "User updated successfully!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/editUser.jsp");
				dispatcher.forward(req, resp);
	        }
	        else {
	        	req.setAttribute("user", user);
	        	req.setAttribute("errorMessage", "Something went wrong");
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/editUser.jsp");
				dispatcher.forward(req, resp);
	        }
		}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
