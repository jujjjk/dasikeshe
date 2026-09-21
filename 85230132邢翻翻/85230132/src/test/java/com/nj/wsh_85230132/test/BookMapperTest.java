package com.nj.wsh_85230132.test;

import com.nj.wsh_85230132.domain.Book;
import com.nj.wsh_85230132.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    public void saveBookTest() {
        Book book = new Book();
        book.setName("黑暗森林");
        book.setType("科幻");
        book.setDescription("描述信息................");
        bookMapper.saveBook(book);
    }

    @Test
    public void findAllBooksTest() {
        List<Book> allBooks = bookMapper.findAllBooks();
        System.out.println("allBooks-> " + allBooks);
    }

    @Test
    public void findById() {
        Book book = bookMapper.findById(2);
        System.out.println("book-> " + book);
    }

    @Test
    public void updateBookTest() {
        Book book = bookMapper.findById(2);
        book.setDescription("java应用开发框架");
        book.setName("SpringBoot框架实战");
        book.setType("计算机应用");
        Integer integer = bookMapper.updateBook(book);
        System.out.println("ingeger-> " + integer);
        List<Book> allBooks = bookMapper.findAllBooks();
        System.out.println("allBooks-> " + allBooks);
    }

    @Test
    public void removeBooktest() {
        Integer integer = bookMapper.removeBookById(1);
        System.out.println("删除了 【" + integer + "】条数据");
        List<Book> allBooks = bookMapper.findAllBooks();
        System.out.println(allBooks);
    }

    @Test
    public void findBoosLikeTest() {
        List<Book> books = bookMapper.findBooksLikeName("Spring");
        System.out.println(books);
    }
}
