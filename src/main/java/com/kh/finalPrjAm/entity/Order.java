package com.kh.finalPrjAm.entity;

import com.kh.finalPrjAm.constant.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 주문 상품 엔티티와 일대다 매핑
    // 외래키 (order_id) 가 order_item 테이블에 있으므로 연관 관계의 주인은 OrderItem 엔티티입니다
    // Order 엔티티가 주인이 아니므로 "mappeBy" 속성으로 연관 관계의 주인을 설정 합니다
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItemList = new ArrayList<>();

    private LocalDateTime orderDate; // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime regTime;
    private LocalDateTime orderTime;
}
