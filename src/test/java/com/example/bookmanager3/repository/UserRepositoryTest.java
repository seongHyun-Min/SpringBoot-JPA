package com.example.bookmanager3.repository;


import static org.junit.jupiter.api.Assertions.*;

import com.example.bookmanager3.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Martin
 * @since 2021/03/10
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() { // create, read, update, delete
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martini-update@fastcampus.com");

        userRepository.save(user);////update 쿼리 실행

        //isNew를 통해서 save가 update쿼리를 실행할지 select를 실행할지 결정된다.
        // pk @id가 널이라면 select를 해줘서 save를 해주고 pk @id가 널이아니라면 update를 해줘서 수정한 save를 해준다.






//        //페이징 @@ 완전중요
//        Page<User> users = userRepository.findAll(PageRequest.of(1,3));
//
//        System.out.println("page :" +users);
//        System.out.println("totalElements :" + users.getTotalElements());
//        System.out.println("totlapages :" + users.getTotalPages());
//        System.out.println("numberOfElements :" + users.getNumberOfElements());
//        System.out.println("sort :" +users.getSort());
//        System.out.println("size :" +users.getSize());
//
//        users.getContent().forEach(System.out::println);



//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L)));
//        //delteAll findALl 성능상 문제 있기 때문에 거의 안써
//
//        userRepository.findAll().forEach(System.out::println);
//


//        userRepository.deleteById(1L);
//
//        userRepository.findAll().forEach(System.out::println);




//        System.out.println(userRepository.existsById(1L)); //실제로 count 쿼리를 이용해서 찾아낸다


//        long count = userRepository.count();
//
//        System.out.println(count);








//        User user = userRepository.findById(1L).orElse(null); //findById로 가저오면 Optional로 매핑되어있다

//        System.out.println(user);





//        User user1 = new User("jack", "jack@naver.com");
//        User user2 = new User("steve", "steve@naver.com");
//
//        userRepository.saveAll(Lists.newArrayList(user1,user2));
//
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);







//        userRepository.save(new User());
//
//        userRepository.findAll().forEach(System.out ::println);
//
////        for(User user: userRepository.findAll()){ userRepository.findall().forEach(System.out ::println);
////            System.out.println(user)
////        }
    }

    @Test
    void select(){
//        System.out.println(userRepository.findByName("dennis"));
//
//        System.out.println("findByEmail :" + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail :" + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail :" + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail :" + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail :" + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail :" + userRepository.streamByEmail("martin@fastcampus.com"));
//
//        System.out.println(userRepository.findTop2ByName("martin"));
//        System.out.println(userRepository.findFirst1ByName("martin"));

        System.out.println(userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));

        System.out.println(userRepository.findByEmailOrName("martin@fastcampus.com", "marse"));

        System.out.println(userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));

        System.out.println(userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));






    }
}