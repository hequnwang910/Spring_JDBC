package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
    @Test
    public void testjdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        //添加
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("java");
//        book.setUstatus("a");
//
//        bookService.addBook(book);


        //修改
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("javall");
//        book.setUstatus("awh");
//
//        bookService.updateBook(book);


        //删除
//        bookService.deleteBook("1");

        //查询返回某个值
//        int count = bookService.findCount();
//        System.out.println(count);

        //查询返回对象
//        Book book = bookService.findOne("1");
//        System.out.println(book);


        //查询返回对象集合
//        List<Book> all = bookService.findAll();
//        System.out.println(all);

        //批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"4","ddd","dd"};
//        Object[] o2 = {"5","fff","ff"};
//        Object[] o3 = {"6","eee","ee"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);


        //批量修改
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"ddd11","dd","4"};
//        Object[] o2 = {"fff11","ff","5"};
//        Object[] o3 = {"eee11","ee","6"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);

        //批量删除
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"4"};
        Object[] o2 = {"5"};
        Object[] o3 = {"6"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);

    }

}
