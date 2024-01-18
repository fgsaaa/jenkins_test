package com.springboot.controller;

import com.springboot.Service;
import com.springboot.entity.User;
import com.springboot.repsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Lock;
import org.springframework.scheduling.annotation.Async;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.LockModeType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
   static int a=1;
    @Autowired
    Service service;
    //http://localhost:8080/saveUser?userName=%E5%A4%A7%E8%80%81%E6%9D%A8&userPassword=123
    @GetMapping(value = "/saveUser")
    public void saveUser() {
        //test1("tst");
       // service.test(userName,userPassword);
        List<User> list =new ArrayList<>();
        User user = new User("111", "2222");
        User user1 = new User("2222", "3333");
        list.add(user);
        list.add(user1);
        service.insertRoleList(list);
//        User user = new User(userName, userPassword);
//
//        userRepository.save(user);
//        System.out.println(user);
//        user.setUserName("11111");
//        userRepository.save(user);
//        System.out.println(user);
//        user.setUserName("2222");
//        userRepository.save(user);
//        System.out.println(user);
    }

    public  void test1(String str) {

        synchronized(str.intern()) {
            System.out.println(a);
            User user = userRepository.findByUserName("11111");
            System.out.println(user);
          a++;
            user.setUserPassword(String.valueOf(a));
            userRepository.save(user);
        }
    }
    @Async
    public void async(){

    }



    //http://localhost:8080/updateUser?Id=1&userName=%E5%A4%A7%E8%80%81%E6%9D%A8&userPassword=1111
    @GetMapping(value = "/updateUser")
    public void updateUser(Long Id, String userName, String userPassword) {
        User user = new User(Id, userName, userPassword);
        userRepository.save(user);
    }

    //http://localhost:8080/deleteUser?Id=1
    @GetMapping(value = "/deleteUser")
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }

    //http://localhost:8080/getUserById?Id=1
    @GetMapping(value = "/getUserById")
    public Optional<User> getUserById(@RequestParam  Long Id) {
        return userRepository.findById(Id);
    }

    //http://localhost:8080/getUserByUserName?userName=dalaoyang
    @GetMapping(value = "/getUserByUserName")
    public List<User> getUserByUserName(String userName) {
        return userRepository.findAllByUserName(userName);
    }


//    @GetMapping("/test")
//    @Transactional
//    public void test(Long Id) {
//        userRepository.findAllByUserName("fgs");
//        try {
//            Thread.sleep(10000);
//        } catch (Exception E) {
//        }
//        saveUser("1", "2");
//    }
}




