package com.nj.wsh_85230132.mapper;

import com.nj.wsh_85230132.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {
    @Update("insert into book(type,name,description) values (#{type},#{name},#{description})")
    public void saveBook(Book book);

    @Select("select * from book")
    public List<Book> findAllBooks();

    @Select("select * from book where id = #{bookId}")
    Book findById(Integer bookId);

    @Update("update book set name = #{name}, type=#{type},description = #{description} where id = #{id} ")
    Integer updateBook(Book book);

    @Update("delete from book where id = #{bookId}")
    Integer removeBookById(Integer bookId);

    @Select("select * from book where name like concat('%',#{name},'%')")
    List<Book> findBooksLikeName(String name);
}
