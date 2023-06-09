package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import com.kh.finalPrjAm.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest // 단위 테스트 및 통합 테스트를 위해 스프링부트에서 제동하는 어노테이션
@TestPropertySource(locations = "classpath:application-test.properties") // 테스트 코드 실행 시 해당 설정 파일을 우선적으로 불러 옴
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        for(int i = 1; i < 10; i++){
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i * 10);
            item.setItemDetail("테스트 상품의 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item saveItem = itemRepository.save(item); // 저장 테스트
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findAll();
        for(Item e : itemList){
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("상품명 or 상품상세설명 테스트")
    public void findByItemNmOrItemDetail(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품5", "테스트 상품의 상세 설명7");
        for(Item e : itemList){
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("입력 받은 가격보다 작은 상품 조회 테스트")
    public void findByPriceLessThanTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThan(10055);
        for(Item e : itemList){
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    public void findByPriceLessThanOrderByPriceDesc(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10076);
        for(Item e : itemList){
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("가격 범위로 상품 조회 테스트")
    public void findByPriceBetweenTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceBetween(10015, 10075);
        for(Item e : itemList){
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("상품 이름에 대한 부분 문자열 검색")
    public void findByItemNmContainerTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNmContaining("상품6");
        for(Item e : itemList){
            System.out.println("결과 ; " + e.toString());
        }
    }

    @Test
    @DisplayName("@Query 를 이용한 상품 조회 테스트")
    public void findByItemDetail(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemDetail("설명7");
        for(Item e : itemList){
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("nativeQuery 속성을 이용한 상품 조회 테스트")
    public void findByItemDetailByNative(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemDetailByNative("설명5");
        for(Item e : itemList){
            System.out.println("결과 : " + e.toString());
        }
    }


}