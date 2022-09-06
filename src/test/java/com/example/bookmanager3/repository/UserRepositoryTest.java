package com.example.bookmanager3.repository;


import static org.junit.jupiter.api.Assertions.*;

import com.example.bookmanager3.domain.Gender;
import com.example.bookmanager3.domain.User;
import org.assertj.core.util.Lists;
import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.web.WebAppConfiguration;

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

    }

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

        System.out.println(userRepository.findByIdBetween(1L, 3L));

        System.out.println(userRepository.findByIdIsNotNull());

        System.out.println(userRepository.findByNameStartingWith("mar"));
        System.out.println(userRepository.findByNameEndingWith("mar"));
        System.out.println(userRepository.findByNameContaining("mar"));

        // sql에서 와일드카드인 %키워드와 동일한 역할
        // contain은 문자열의 양 끝 에 %가 들어가는거고
        // start는 문자열 앞에 %가 들어가고 end는 문자열 뒤에 %가 들어가게 된다
        // 또한 그냥 Like 쿼리 메소드를 만들어도 이 3가지의 동일한 로직을 실행할수 있게 된다.
        // 그러나 실제로는 파라미터로 받을때 문자열을 계속 결합해야되느 상황이 생기므로 가독성이 많이 떨어지게 된다.
        // 즉 like 쿼리 메소드를 단순히 만들기보다는 start end contain으로 각각 쿼리 메소드를 만들어주는 것이

    }
    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName :" +userRepository.findTop1ByName("martin"));
//        System.out.println("findLast1ByName :" + userRepository.findByName("martin")); //
        System.out.println("findTop1ByNameOrderByDesc :" + userRepository.findTop1ByNameOrderByIdDesc("martin"));
        // 정렬 추가
        System.out.println("findFirstByNameOrderByIdDescEmailAsc" + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));

        System.out.println("Sort 객체를 활용하여 정렬" + userRepository.findByName("martin", Sort.by(Sort.Order.asc("Name"))));
        // Sort 클래스는 내부 클래스로 정의돼 있는 order 개체를 활용해 정렬 기준을 생성한다
        // 매개변수를 활용한 쿼리 메서드를 사용하면 쿼리 메서드를 정의하는 단게에서 코드가 줄어드는 장점이있다
        // 그러나 호출하는 위치에서 여전히 정렬 기준이 길어져 가독성이 떨어진다

        System.out.println("페이징 : " + userRepository.findByName("martin", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))));
        // 객체 값을 리턴
        System.out.println("페이징 : " + userRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getContent());
        //실제 값을 리턴
    }

    @Test
    void insertAndUpdaetTest(){
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");

        userRepository.save(user2);

        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void enumTest() {
    User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
    user.setGender(Gender.MALE);
    userRepository.save(user);

    userRepository.findAll().forEach(System.out::println);

    System.out.println(userRepository.findRawRecord().get("gender"));
    // 결과갓이 0이 나오는 이유는 enum 클래스에서 Male이 0번 순서이기 때문이다.
    }

    @Test
    void listerTest(){
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("martinnn");

        userRepository.save(user2);

        userRepository.deleteById(4L);


    }


}