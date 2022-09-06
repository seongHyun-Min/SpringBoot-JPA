package com.example.bookmanager3.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper =true) //상속받는 클래스의
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    private Long bookId;

    private float averageReviewScore;

    private int reviewCount; // 프리미타입을 사용하는 이유는 null을 허용하는지 허용안할지
    // 기본값을 0으로 할려고 프리미타입을 사용한것이고 만약 래퍼 타입으로 선언하면 null을 허용할수 있다.
}
