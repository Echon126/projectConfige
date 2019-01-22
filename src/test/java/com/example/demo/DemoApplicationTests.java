package com.example.demo;


import com.example.demo.aop.Dao;
import com.example.demo.tx.service.TxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void TestAop() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/aop.xml");
        Dao dao = (Dao) ac.getBean("daoImpl");
        dao.select();
    }

    @Autowired
    TxService txService;

    @Test
    public void testTx() throws Exception {
        txService.createData();
    }
}
