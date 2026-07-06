package com.lms.serviceImpl;

import java.util.List;

import com.lms.dao.BookDao;
import com.lms.daoImpl.BookDaoImpl;
import com.lms.pojo.Book;
import com.lms.service.BookService;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    }

    @Override
    public List<Book> getAllBookList() {
        return bookDao.getAllBookList();
    }

    @Override
    public List<Book> getAllBookByStatus(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBookByStatus'");
    }
    
}
