package com.example.bookmanager3.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
// @Table(name = "user_legacy") 일반적으로 테이블과 이름은 1대1 매핑 시켜주는것이 좋다
// @Table 어노테이션에서 indexes = 를 붙혀주면 index를 사용할 수 있다.
public class User extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Column(updatable = false)
    private LocalDateTime updatedAt;
    //DB는 유지하면서 application의 가독성을 맞춰주기 위하여 변수를 db에있는 변수와 같은 변수로 선언한후
    // @Column = (name을 바꿔주면 가독성이 좋은 코드를 작성할 수 있다.
    //@column(nullable =false) 를 붙혀주면 not null이 붙은 속성을 생성 할 수 있다.

    @Transient // transient를 붙혀주게 되면 영속성 처리에서 제외되기때문에 데이터베이스에 반영되지 않는다 autoDDL을 만들때에도 ddl이 만들어지지 않는다.
    private String testData;



//    @PrePersist
//    @PreUpdate // merge 메서드가 실행된 이전에 실행
//    @PreRemove  // remove 메서드가 실행된 이전
//    @PostPersist
//    @PostUpdate
//    @PostRemove
//    @PostLoad

/*    @PrePersist
    public void prePersist() {
        System.out.println(">>>>> PrePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println(">>>>> PostPersist");
    }*/

    @PreUpdate
    public void preUpdate() {
        System.out.println(">>>>> PreUpdate");
    }
}

//    @PostUpdate
//    public void PostUpdate() {
//        System.out.println(">>>>> PostUpdate");
//    }
//
//    @PreRemove
//    public void PreRemove() {
//        System.out.println(">>>>> PreRemove");
//    }
//
//    @PostRemove
//    public void PostRemove() {
//        System.out.println(">>>>> PostRemove");
//    }
//
//    @PostLoad
//    public void PostLoad() {
//        System.out.println(">>>>> PostLoad");
//    }
//}
//
//
//
//
//
//    //@Column(Unique)
//    //@Column
