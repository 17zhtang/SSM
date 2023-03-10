package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
//    @Transactional(
//            //只读，优化查询sql
////            readOnly = true;
//            //设置事务超时时长，单位秒，超时将回滚事务
////            timeout = 3
//            //不因某异常而回滚
////            noRollbackFor = ArithmeticException.class
//            //设置事务的隔离级别
////            isolation = Isolation.DEFAULT
//            //设置事务的传播
////            propagation = Propagation.REQUIRED //默认值，使用上级的事务
////            propagation = Propagation.REQUIRES_NEW  //开启新事务
//    )

    public void buyBook(Integer userId, Integer bookId) {
        //查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);

        //更新图书库存
        bookDao.updateStock(bookId);

        //更新用户余额
        bookDao.updateBalance(userId,price);
    }
}
