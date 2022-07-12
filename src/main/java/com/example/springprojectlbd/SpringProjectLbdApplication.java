package com.example.springprojectlbd;

import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;

@SpringBootApplication
public class SpringProjectLbdApplication {
    @Autowired
    OneHundred oneHundred;
@PostConstruct
public void function(){
    oneHundred.createOneHunderStory();

}
@PostConstruct
public void save(){
    oneHundred.saving();
}
    public static void main(String[] args) {
        SpringApplication.run(SpringProjectLbdApplication.class, args);

    }

}
