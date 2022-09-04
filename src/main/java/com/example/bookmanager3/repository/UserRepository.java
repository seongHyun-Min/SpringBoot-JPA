package com.example.bookmanager3.repository;

import com.example.bookmanager3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

      List<User> findFirst1ByName(String name);
      List<User> findTop2ByName(String name);
      //둘다 동일한 결과를 반환하며 first랑 top 뒤에있는 숫자의 갯수만큼 리턴한다


    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);
}
