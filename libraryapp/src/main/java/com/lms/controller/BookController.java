package com.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lms.pojo.Book;
import com.lms.service.BookService;
import com.lms.serviceImpl.BookServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            String numberOfcopies = req.getParameter("numberOfcopies");

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

                if(!booklist.isEmpty() && booklist != null){
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
        else{
            System.out.println("No action found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
