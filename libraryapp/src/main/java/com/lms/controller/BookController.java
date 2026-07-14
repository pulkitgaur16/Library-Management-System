package com.lms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lms.pojo.Book;
import com.lms.pojo.BookIssued;
import com.lms.pojo.User;
import com.lms.service.BookService;
import com.lms.service.UserService;
import com.lms.serviceImpl.BookServiceImpl;
import com.lms.serviceImpl.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BookController")
public class BookController extends HttpServlet {

    public BookController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        //System.out.println("action: " +action); // to see what is coming in action;

        if("showAddBook".equalsIgnoreCase(action)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addBook.jsp");
            dispatcher.forward(req, resp);
        }

        else if("addbook".equalsIgnoreCase(action)){
            String bookTitle = req.getParameter("bookTitle");
            String author = req.getParameter("author");
            String isbn = req.getParameter("isbn");
            String category = req.getParameter("category");
            String publisher = req.getParameter("publisher");
            String availableCopies = req.getParameter("availableCopies");
            String numberOfcopies = req.getParameter("numberofcopies");

            Book book = new Book();
            book.setTitle(bookTitle);
            book.setAuthor(author);
            book.setCategory(category);
            book.setIsbn(isbn);
            book.setPublisher(publisher);
            book.setTotalCopies(Integer.parseInt(numberOfcopies));
            book.setAvailableCopies(Integer.parseInt(availableCopies));
            book.setCreatedAt(new Date());
            book.setStatus("AVAILABLE");

            BookService bookService = new BookServiceImpl();
            boolean flag = bookService.addBook(book);

            if(flag){
                List<Book> booklist = new ArrayList<>();
                booklist = bookService.getAllBookList();

                if(booklist != null && !booklist.isEmpty()){
                    req.setAttribute("booklist", booklist);
                    req.setAttribute("successMessage", "Book added successfully");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/bookList.jsp");
                    dispatcher.forward(req, resp);
                }
                else{
                    req.setAttribute("errorMessage", "Something went wrong");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addBook.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            else{
                req.setAttribute("errorMessage", "Something went wrong");
                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addBook.jsp");
                dispatcher.forward(req, resp);
            }

        }
        else if("allBookList".equalsIgnoreCase(action)){
            List<Book> booklist = new ArrayList<>();

            BookService bookService = new BookServiceImpl();
            booklist = bookService.getAllBookList();

            if(!booklist.isEmpty() && booklist != null){
                req.setAttribute("booklist", booklist);
                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/bookList.jsp");
                dispatcher.forward(req, resp);
            }
        }
        else if("viewBook".equalsIgnoreCase(action)){
            List<Book> booklist = new ArrayList<>();
            long bookId = Integer.parseInt(req.getParameter("bookId"));

            BookService bookService = new BookServiceImpl();
            Book book = bookService.getBookById(bookId);
            if(book!=null){
                req.setAttribute("book", book);

                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/editBook.jsp");
                dispatcher.forward(req, resp);
            }
            else{
                booklist = bookService.getAllBookList();

                if(!booklist.isEmpty() && booklist != null){
                    req.setAttribute("errorMessage", "Book data not found !!");
                    req.setAttribute("booklist", booklist);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/bookList.jsp");
                    dispatcher.forward(req, resp);
                }
            }
        }
        else if("updateBook".equalsIgnoreCase(action)){
            String bookTitle = req.getParameter("bookTitle");
            String author = req.getParameter("author");
            String isbn = req.getParameter("isbn");
            String category = req.getParameter("category");
            String publisher = req.getParameter("publisher");
            String availableCopies = req.getParameter("availableCopies");
            String numberOfcopies = req.getParameter("numberOfcopies");
            long bookId = Integer.parseInt(req.getParameter("bookId"));

            Book book = new Book();
            book.setTitle(bookTitle);
            book.setAuthor(author);
            book.setCategory(category);
            book.setIsbn(isbn);
            book.setPublisher(publisher);
            book.setTotalCopies(Integer.parseInt(numberOfcopies));
            //book.setAvailableCopies(Integer.parseInt(availableCopies));
            book.setBookId(bookId); 

            BookService bookService = new BookServiceImpl();
            boolean updatedFlag = bookService.updateBook(book);

            if(updatedFlag){
                book.setAvailableCopies(Integer.parseInt(availableCopies));
                req.setAttribute("book", book);
                req.setAttribute("successMessage", "Book updated successfully");

                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/editBook.jsp");
                dispatcher.forward(req, resp);
            }
            else{
                req.setAttribute("errorMessage", "Something went wrong");

                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/editBook.jsp");
                dispatcher.forward(req, resp);
            }
        }
        else if("showAssignBook".equalsIgnoreCase(action)) {
			UserService userService = new UserServiceImpl();
			BookService bookService = new BookServiceImpl();
			
			List<Book> bookList = new ArrayList<>();
			bookList = bookService.getAllAvailableBookList();
			
			List<User> userList = new ArrayList<>();
			userList = userService.getAllUserList();
			
			if(bookList != null && bookList.size() > 0 && userList !=null && userList.size() > 0) {
				req.setAttribute("bookList", bookList);
				req.setAttribute("userList", userList);
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/assignBook.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("errorMessage", "Either book or user not available. Please try again.");
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/assignBook.jsp");
				dispatcher.forward(req, resp);
			}
		}
		else if("assignBook".equalsIgnoreCase(action)) {
			long bookId = Long.parseLong(req.getParameter("bookId"));
			long userId = Long.parseLong(req.getParameter("userId"));
			
			String dueDate = req.getParameter("dueDate");
			String assignmmentNotes = req.getParameter("assignmmentNotes");
			
			Book book = new Book();
			book.setBookId(bookId);
			
			User user = new User();
			user.setUserId(userId);
			
			BookIssued bookIssued = new BookIssued();
			bookIssued.setBook(book);
			bookIssued.setUser(user);
			
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDueDate = null;
	        try {
	            localDueDate = LocalDate.parse(dueDate, dateFormatter);
	            System.out.println("Parsed localDueDate: " + localDueDate);
	        } catch (DateTimeParseException e) {
	            System.err.println("Error parsing date: " + e.getMessage());
	        }
			
			bookIssued.setDueDate(localDueDate);
			bookIssued.setAssignmentNotes(assignmmentNotes);
			
			BookService bookService = new BookServiceImpl();
			boolean assignflag = bookService.assignBook(bookIssued);
			if(assignflag) {
				HttpSession session = req.getSession();
				session.setAttribute("sucessMessage", "Book assign successful!!");
				resp.sendRedirect("BookController?action=showAssignBook");
			}
			else {
				req.setAttribute("errorMessage", "Book not assigned. Please try again.");
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/assignBook.jsp");
				dispatcher.forward(req, resp);
			}
		}
        else if("showReturnBook".equalsIgnoreCase(action)) {
			BookService bookService = new BookServiceImpl();
			List<BookIssued> issuedList = bookService.getAllIssuedBookList();
			
			// Safety fallback: Initialize an empty list if database returns null
            if(issuedList == null) {
                issuedList = new ArrayList<>();
            }
    
            // Only parse statuses if elements actually exist
            if(!issuedList.isEmpty()) {
                LocalDate today = LocalDate.now();
                for (BookIssued bookIssued : issuedList) {
                    LocalDate dueDate = bookIssued.getDueDate();
                    if(dueDate.isBefore(today)) {
                        bookIssued.setDueDayStatus("Overdue");
                    }
                    else if(dueDate.isEqual(today)) { 
                        bookIssued.setDueDayStatus("Due Today");
                    }
                    else {
                        bookIssued.setDueDayStatus("Active");
                    }
                }
            }
    
            // FIX: This now executes EVERY single time, even if the database table is empty!
            req.setAttribute("issuedList", issuedList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/returnBook.jsp");
            dispatcher.forward(req, resp);
		}
		else if("showReturnBookDetails".equalsIgnoreCase(action)) {
			long issuedId = Long.parseLong(req.getParameter("issuedId"));
			
			BookService bookService = new BookServiceImpl();
			BookIssued bookIssued = bookService.getIssuedBookById(issuedId);
			
			if(bookIssued != null) {
				req.setAttribute("bookIssued", bookIssued);
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/showReturnBookDetails.jsp");
				dispatcher.forward(req, resp);
			}
		}
		else if("returnBook".equalsIgnoreCase(action)) {
			int issuedId = Integer.parseInt(req.getParameter("issuedId"));
			String returnDate = req.getParameter("returnDate");
			String bookCondition = req.getParameter("bookCondition");
			String returnNotes = req.getParameter("returnNotes");
			
			BookIssued bookIssued = new BookIssued();
			bookIssued.setIssueId(issuedId);
			
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localReturnDate = null;
	        try {
	        	localReturnDate = LocalDate.parse(returnDate, dateFormatter);
	        } catch (DateTimeParseException e) {
	            System.err.println("Error parsing date: " + e.getMessage());
	        }
			
			bookIssued.setReturnDate(localReturnDate);
			bookIssued.setBookCondition(bookCondition);
			bookIssued.setReturnNotes(returnNotes);
			
			BookService bookService = new BookServiceImpl();
			boolean flag = bookService.updateBookReturn(bookIssued);
			
			if(flag) {
				HttpSession session = req.getSession();
				session.setAttribute("sucessMessage", "Book return successful!!");
				resp.sendRedirect("BookController?action=showReturnBook");
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("errorMessage", "Something went wrong");
				resp.sendRedirect("BookController?action=showReturnBook");
			}
		}
        else{
            System.out.println("No action found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
