package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class UserTest {

    @Test
    void test(){
        User user1 = new User();
        user1.setEmail("Martin");
        user1.setName("martin");
        user1.setCreatedAt(LocalDateTime.now());
        user1.setUpdatedAt(LocalDateTime.now());


        User user3 = User.builder()
                .name("kim")
                .email("kim@")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User user2 = new User(null,"park","park2",Gender.MALE,LocalDateTime.now(),LocalDateTime.now());


        System.out.println(">>>" + user1);
        System.out.println(">>>" + user2);
        System.out.println(">>>" + user3);
    }
}