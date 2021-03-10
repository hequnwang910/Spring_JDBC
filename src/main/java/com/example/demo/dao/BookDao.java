package com.example.demo.dao;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    //修改的方法
    void updateBook(Book book);
    //删除的方法
    void deleteBook(String id);
    //查询表记录数
    int selectCount();
    //查询返回对象
    Book findBookInfo(String id);
    //查询返回集合
    List<Book> findAllBook();

    //批量添加
    void batchAddBook(List<Object[]> batchArgs);
    //批量修改
    void batchUpdateBook(List<Object[]> batchArgs);
    //批量删除
    void batchDeleteBook(List<Object[]> batchArgs);
}
