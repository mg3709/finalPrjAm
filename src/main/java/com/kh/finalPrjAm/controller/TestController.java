package com.kh.finalPrjAm.controller;

import com.kh.finalPrjAm.dto.MemberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api") // 요청을 받기 위한 어노테이션
public class TestController {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello, Spring Boot !!!!";
    }

    @GetMapping("/variable1/{var}") // 매개변수를 전달 받을 때 사용함
    public String getVariable1(@PathVariable String var){
        return var;
    }

    @GetMapping("/request1")
    public String getRequestParam(
            @RequestParam String user,
            @RequestParam String name,
            @RequestParam String email
    ){
        return user + " " + name + " " + email;
    }

    @GetMapping("/members")
    public List<Map<String, Object>> memberList(){
        List<Map<String, Object>> members = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            Map<String, Object> member = new HashMap<>();
            member.put("id", i);
            member.put("name", i + "번 개발자");
            member.put("age", 10 + i);
            members.add(member);
        }

        return members;

    }

    @PostMapping("/member-reg")
    public boolean memberReg(@RequestBody Map<String, String> data){
        String id = data.get("user");
        String pwd = data.get("pwd");
        String name = data.get("name");
        String email = data.get("email");
        System.out.println("id : " + id + "pwd : " + pwd + "name : " + name + "email : " + email);
        return true;
    }

    @GetMapping("/members2")
    public ResponseEntity<List<MemberDTO>> memberList2(){
        List<MemberDTO> list = new ArrayList<>();
        for(int i =0; i < 10; i++){
            MemberDTO dto = new MemberDTO();
            dto.setUser("kmg0205");
            dto.setPwd("opop");
            dto.setName("김민기");
            dto.setEmail("kmg0205@naver.com");
        }
            return ResponseEntity.ok(list);
    }

}
