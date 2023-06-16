package com.kh.finalPrjAm.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDTO {
    private String itemNm;
    private int price;
    private String itemDetail;
    private LocalDateTime regTime;
}
