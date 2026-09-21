package com.nj.wsh_85230132.test;

import com.nj.wsh_85230132.domain.Book;
import com.nj.wsh_85230132.mapper.BookMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookMapper2Test {

    @Autowired
    private BookMapper2 bookMapper2;

    /**
     * 测试新增book
     */
    @Test
    public void testInsert() {
        Book book = new Book();
        book.setName("机器学习");
        book.setType("大数据");
        book.setDescription("描述信息");
        int insert = bookMapper2.insert(book);
        System.out.println("BookMapper2Test.testInsert-> " + insert);
    }

    @Test
    public void updateBookById() {
        Book book = bookMapper2.selectById(1166045185);
        book.setDescription("修改");
        book.setName(book.getName() + "-修改");
        book.setType(book.getType() + "修改");
        int update = bookMapper2.updateById(book);
        System.out.println("update-> " + update);
    }

    @Test
    public void getBoos() {
        List<Book> list = bookMapper2.selectList(null);
        System.out.println("BookMapper2Test.getBoos-> " + list);
    }

    @Test
    public void getBooksById() {
        Book book = bookMapper2.selectById(4);
        System.out.println("BookMapper2Test.getBooksById-> " + book);
    }

    @Test
    public void deleteBook() {
        int i = bookMapper2.deleteById(1166045185);
        System.out.println("BookMapper2Test.deleteBook-> " + i);
    }
}
