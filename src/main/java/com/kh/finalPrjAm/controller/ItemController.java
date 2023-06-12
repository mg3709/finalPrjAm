package com.kh.finalPrjAm.controller;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import com.kh.finalPrjAm.dto.ItemDTO;
import com.kh.finalPrjAm.entity.Item;
import com.kh.finalPrjAm.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController (ItemService itemService){
        this.itemService = itemService;
    }

    //제품 등록
    @PostMapping("/new")
    public ResponseEntity<Boolean> itemCreate (@RequestBody Map<String, Object> data){
        String name = (String) data.get("name");
        int price = (Integer) data.get("price");
        String detail = (String) data.get("detail");
        int stock = (Integer) data.get("stock");
        String status = (String) data.get("status");
        boolean rst = itemService.createItem(name, price, detail, ItemSellStatus.SELL, stock);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // 제품 조회
    @GetMapping("/get")
    public ResponseEntity<List<ItemDTO>> itemList(@RequestParam String name){
        List<ItemDTO> list = itemService.getItemList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
