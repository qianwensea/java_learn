package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {
//    @RequestMapping(value="/hello")
//    public String hello(){
//        return "hello world";
//    }
public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
}
class User {
    String name;
    String password;
    public String getName(){
        return  name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return  password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String toString(){
        return "user{name='"+name+"\',"+"password="+password+"}";
    }
}
    public interface UserService {
        public User getUserInfo();
    }
    @Service
   class UserServiceImpl implements UserService {
        public User getUserInfo(){
            User user = new User();
            user.setName("shienze");
            user.setPassword("dashabi");
            return user;
        }
    }
    @RestController
    static
    class UserController {
        @Autowired
        UserService service;

            @RequestMapping(value = "/getUserItem",method = RequestMethod.GET)
//        @RequestMapping(value = "/getUserItem")
        public String getUserItem() {
            User user = service.getUserInfo();
            return user.toString();
        }



    }}
