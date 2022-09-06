package com.example.bookmanager3.repository;

import com.example.bookmanager3.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    List<User> findByCreatedAtBetween(LocalDateTime yesterdaty, LocalDateTime tomorrow); // 비트윈이니까 인자 2개를 받아

    List<User> findByIdBetween(Long id1, Long id2);
    //by 뒤에 네임을 정확히 일치시키지 않는다면 오류가 발생한다

    List<User> findByIdIsNotNull(); //인자를 받지 않는다

    // emptu는 null 값이 아닌 컬렉션의 빈 문자를 확인하게 된다

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContaining(String name);

    // Is 생략 되는 경우가 많으며  equal이랑 동일한 역할을 한다

    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name);
    // Last1을 인식하지못해 그냥 findByName으로 인식하게 된다.

    List<User> findTop1ByNameOrderByIdDesc(String name); //Desc 역순으로 정렬후 하나만 default는 Asc이다

    //정렬 추가
    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);
    //select에 Email이 없더라도 OrderBy에 사용할수 있으며 order by에는 and나 or 키워드를 붙히지 않는다.

    // 그러나 메소드 이름에 orderby를 넣으면 메소드의 길이가 길어저 가독성이 떨어진다
    List<User> findByName(String name, Sort sort); //find By name 을 오버로딩 시켜준다 매개변수가 다른 인자로 받아서

    Page<User> findByName(String name, Pageable pageable);

    // 쿼리메소드의 이름만으로 쿼리 메서드를 생성할수도 있고
    //  튜닝된 커리를 사용하고자 할 때 직접 SQL으르 작성한다.
    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRawRecord();
}
