package com.example.springprojectlbd;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@SpringBootApplication
public class SpringProjectLbdApplication {

    OneHundred oneHundred;


@PostConstruct
public void function(){
    oneHundred.createOneHundredStory();

}
@PostConstruct
public void save(){
    oneHundred.saving();
}
    public static void main(String[] args) {
        SpringApplication.run(SpringProjectLbdApplication.class, args);

    }

}
