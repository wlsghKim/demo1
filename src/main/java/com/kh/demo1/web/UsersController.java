package com.kh.demo1.web;

import com.kh.demo1.web.api.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

//@Controller // view + data
@RestController // data
public class UsersController {

  //등록
  @PostMapping("/users")
  public ApiResponse<Set<User>> add(){
    Set<User> users = new HashSet<>();
    User u1 = new User(1,"test1@test.com","홍길동1",10);
    User u2 = new User(2,"test2@test.com","홍길동2",20);
    User u3 = new User(3,"test3@test.com","홍길동3",30);
    users.add(u1);
    users.add(u2);
    users.add(u3);

    ApiResponse<Set<User>> res = ApiResponse.createApiResMsg("00", "성공", null);
    return res;
  }

  //조회

  //수정

  //삭제

  //목록
  @Data
  @AllArgsConstructor
  static class User {
    private long id;
    private String email;
    private String name;
    private int age;
  }
}
