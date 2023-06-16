package com.kh.finalPrjAm.controller;

import com.kh.finalPrjAm.dto.ItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/item")
    public String tymeleafItem(Model model){
        ItemDTO itemDto = new ItemDTO();
        itemDto.setItemNm("LG 오브제 에어컨");
        itemDto.setItemDetail("에이컨 입니다");
        itemDto.setPrice(200);
        itemDto.setRegTime(LocalDateTime.now());
        model.addAttribute("itemDto", itemDto);
        return "thymeleaf/thymeleafItem";
    }

    @GetMapping("item-list")
    public String thymeleafItemList(Model model){
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for(int i  = 1; i <= 10; i++){
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemNm("테스트 상품 " + i);
            itemDTO.setItemDetail("테스트 상품 상세 설명" + i);
            itemDTO.setPrice(1000 * i);
            itemDTO.setRegTime(LocalDateTime.now());
            itemDTOList.add(itemDTO);
        }
        model.addAttribute("itemDtoList", itemDTOList);
        return "thymeleaf/thymeleafItemList";
    }

    @GetMapping("link-test")
    public String thymeleafLinkTest(String param1, String param2, Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleaf/thymeleafLinkTest";
    }


}
