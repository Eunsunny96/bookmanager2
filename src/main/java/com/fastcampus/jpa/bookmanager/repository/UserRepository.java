package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Long> { //sping data jpa 라이브러리 상송

    //User findByName(String name); //값이 2개 이상이면 error 가 뜸
    //Set<User> findByName(String name);
    //Optional<User> findByName(String name);
    List<User> findByName(String name);
    User findByEmail (String email);
    User getByEmail(String email);
    User readByEmail(String email);
    User searchByEmail(String email);
    User queryByEmail(String email);
    User streamByEmail(String email);
    User findUserByEmail(String email);

    List<User> findFirst1ByName(String name);
    List<User> findTop1ByName(String name);

    List<User> findByEmailAndName(String email, String name);
    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<User> findByIdBetween(Long id1,Long id2);

    List<User> findByIdIsNotNull();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);

    List<User> findTop1ByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);
    List<User> findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);







}
