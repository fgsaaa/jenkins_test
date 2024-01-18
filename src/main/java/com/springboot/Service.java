package com.springboot;

import com.springboot.entity.User;
import com.springboot.repsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ApplicationContext applicationContext;
    @Async
    public void  test(String userName, String userPassword){
       // User user = new User(userName, userPassword);
        User user= userRepository.findByUserName("11111");
        System.out.println(user);
        user.setUserPassword("hhhh");
        userRepository.save(user);
        System.out.println(user);
        user.setUserPassword("11111");
        userRepository.save(user);
        System.out.println(user);
        user.setUserPassword("2222");
        userRepository.save(user);
        System.out.println(user);
    }



    @Transactional(propagation= Propagation.REQUIRES_NEW,
            isolation= Isolation.READ_COMMITTED)
    public void insertRole(User user) {
           userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int insertRoleList(List<User> roleList) {
        Service service= applicationContext.getBean(Service.class);
        int count=0;
        for (User role:roleList) {
            service.insertRole(role);
            count++;
        }
        return count;
    }

}
