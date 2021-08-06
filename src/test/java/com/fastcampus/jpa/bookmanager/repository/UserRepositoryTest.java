package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void crud() {// create , read, update, delete
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);

    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("martin"));
//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//
//        System.out.println("findTop1OneByName : " + userRepository.findTop1ByName("martin"));
//        System.out.println("findFirst1OneByName : " + userRepository.findFirst1ByName("martin"));

//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcapus","martin"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcapus","dennis"));
//
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")) );
//
//        System.out.println("findBynameStartingWith : " + userRepository.findByNameStartingWith("mar"));
//        System.out.println("findBynameEndingWith : " + userRepository.findByNameEndingWith("tin"));
//        System.out.println("findBynameContains: " + userRepository.findByNameContains("art"));
//
//        System.out.println("findBynameLike: " + userRepository.findByNameLike("%art%"));


    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("finbByNameWithPaging: " +userRepository.findByName("martin",PageRequest.of(0,1,Sort.by(Sort.Order.desc("id")) )).getContent());
    }

    @Test
    void insertAndUpdateTest(){
        User user = new User();
        user.setName("martin");
        user.setEmail("martin@fastcampus.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        userRepository.save(user2);

    }

    @Test
    void enumTest(){

   User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);


    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("martin@fast.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("maaaartin");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }
    @Test
    void prePersistTest(){
        User user = new User();
        user.setEmail("martin@fast.com");
        user.setName("martin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin@fast.com"));
    }

        @Test
        void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be: " + userRepository.findAll().get(0));
    }
    @Test
    void userHistoryTest(){
        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");

        userRepository.save(user);

        user.setName("martin-new-new");

        userRepository.save(user);
        userHistoryRepository.findAll().forEach(System.out::println);
    }


    }
