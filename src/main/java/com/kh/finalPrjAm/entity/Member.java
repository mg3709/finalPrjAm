package com.kh.finalPrjAm.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // JPA에 Entity 클래스임을 알려줌, DB Table로 만들어져야 할 클래스
@Data
@Table(name = "member")
public class Member {
    @Id // 해당 필드가 primary key 임을 지정
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String name;
    private String pwd;
    @Column(unique = true)
    private String email;
    private LocalDateTime joinTime;
}
