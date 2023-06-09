package com.kh.finalPrjAm.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cartName;

    @OneToOne // 1 : 1 관계 매핑
    @JoinColumn(name = "member_id") // 매핑할 외래키 지정
    private Member member;


}
