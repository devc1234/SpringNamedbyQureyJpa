package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String...args) throws Exception {
    	User user = new User();
        user.setActive(1);
        user.setAge(28);
        user.setEmailAddress("Namdevgmail.com");
        user.setFirstname("Namdev");
        user.setLastname("Chavan");
        user.setStartDate(new Date());
        user = userRepository.save(user);

        System.out.println("-------------------------------------:: " + user.getId());

        System.out.println(" ---------------@NamedQuery ---------------------");
        System.out.println("--------------findByEmailAddress -----------------");

        User user2 = userRepository.findByEmailAddress("Namdevgmail.com");
        System.out.println(user2.toString());

        System.out.println(" ---------------@NamedQuery ---------------------");
        System.out.println("--------------findByLastname -----------------");

        List < User > user3 = userRepository.findByLastname("chavan");
        System.out.println(user3.get(0).toString());
    }
}