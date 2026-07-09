package com.lms.serviceImpl;

import java.util.Date;
import java.util.List;

import com.lms.dao.BookDao;
import com.lms.daoImpl.BookDaoImpl;
import com.lms.pojo.Book;
import com.lms.pojo.BookIssued;
import com.lms.service.BookService;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
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

    @Override
    public Book getBookById(long bookId) {
        return bookDao.getBookById(bookId);
    }
    
    @Override
	public List<Book> getAllAvailableBookList() {
		return bookDao.getAllAvailableBookList();
	}

	@Override
	public boolean assignBook(BookIssued bookIssued) {
		bookIssued.setIssueDate(new Date());
		bookIssued.setStatus("ISSUED");
		
		boolean assignFlag = false;
		Book book = bookDao.getBookById(bookIssued.getBook().getBookId());
		if(book != null) {
			int availableCopies = book.getAvailableCopies() - 1;
			
			boolean updateflag = bookDao.updateAvailableBook(bookIssued.getBook().getBookId(), availableCopies);
			
			if(updateflag) {
				assignFlag = bookDao.assignBook(bookIssued);
				
				if(!assignFlag) {
					Book book1 = bookDao.getBookById(bookIssued.getBook().getBookId());
					int newAvailableCopies = book1.getAvailableCopies() + 1;
					bookDao.updateAvailableBook(bookIssued.getBook().getBookId(), newAvailableCopies);
				}
			}
		}
		
		return assignFlag;
	}
}
