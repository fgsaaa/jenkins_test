package com.springboot;

import com.springboot.repsitory.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter43ApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Test
    public void contextLoads() {
        System.out.println(1111);
        System.out.println(userRepository.findById(27L).get());
    }

}
