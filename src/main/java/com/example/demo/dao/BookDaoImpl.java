package com.example.demo.dao;


import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    //添加的方法
    @Override
    public void add(Book book) {


        //1、创建sql语句
        String sql = "insert into t_book values(?,?,?)";

        //2、调用方法实现
        Object[] arg = {book.getUserId(), book.getUsername(), book.getUstatus()};

        int update = jdbcTemplate.update(sql, arg);

        System.out.println(update);
    }
    //修改的方法
    @Override
    public void updateBook(Book book) {

        //1、创建sql语句
        String sql = "update t_book set username = ? ,ustatus = ? where  user_id = ?";

        //2、调用方法实现
        Object[] arg = { book.getUsername(), book.getUstatus(),book.getUserId()};

        int update = jdbcTemplate.update(sql, arg);

        System.out.println(update);



    }
    //删除的方法
    @Override
    public void deleteBook(String id) {
        //1、创建sql语句
        String sql = "delete from t_book where  user_id = ?";

        //2、调用方法实现
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);

    }

    //查询表记录数
    @Override
    public int selectCount() {
        //1、创建sql语句
        String sql = "select count(*) from t_book";

        //2、调用方法实现
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;

    }

    //查询返回对象
    @Override
    public Book findBookInfo(String id) {

        //1、创建sql语句
        String sql = "select * from t_book where user_id = ?";

        //2、调用方法实现
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);

        return book;
    }
    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        //1、创建sql语句
        String sql = "select * from t_book ";

        //2、调用方法实现
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));

        return bookList;


    }
    //批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        //1、创建sql语句
        String sql = "insert t_book values (?,?,?)";

        //2、调用方法实现
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        //1、创建sql语句
        String sql = "update t_book set username = ? ,ustatus = ? where  user_id = ?";

        //2、调用方法实现
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);

        System.out.println(Arrays.toString(ints));
    }
    //批量删除
    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {

        //1、创建sql语句
        String sql = "delete from t_book where  user_id = ?";

        //2、调用方法实现
        int[] update = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(update));
    }
}
