package com.kh.finalPrjAm.entity;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity // JPA Entity 클래스임을 알려줌 Entity 클래스는 반드시 기본키가 있어야 합니다
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA 구현체의 생성 전략을 따름
    private Long id; // primary key

    @Column(nullable = false, length = 50)
    private String itemNm; // 상품 코드

    @Column(nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고 수량

    @Lob // 기존 문자열 보다 더 긴 문자열 사용할 때 추가
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 정보

    @Enumerated(EnumType.STRING) //
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록 시간

    private LocalDateTime updateTime; // 수정 시간

}
