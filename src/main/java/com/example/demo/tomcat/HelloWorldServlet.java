package com.example.demo.tomcat;

import java.io.IOException;

/**
 * @author admin
 * @date 2018-9-21 10:06
 */
public class HelloWorldServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try{
            myResponse.write("get hello world.....");
        }catch (IOException r){
            r.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try{
            myResponse.write("post hello world.....");
        }catch (IOException r){
            r.printStackTrace();
        }
    }
}
