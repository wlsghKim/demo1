package com.kh.demo1.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j   // log.info(),log.error(),log.debug(),log.trace(),log.warning()
@Controller
@RequestMapping("/pubData2")
public class PublicData2Controller {

  @GetMapping("/bn")
  public String businessNumberChk(){
    return "pub/businessNumberChk";
  }

  @GetMapping("/bn2")
  public String businessNumberChk2(){
    return "pub/businessNumberChk2";
  }
  //1) 쿼리파라미터
  @GetMapping("/bn3")
  public String businessNumberChk2(
      @RequestParam("businessNm") String businessNm,
      @RequestParam("name") String name
  ){

    log.info("businessNm={}", businessNm);
    log.info("name={}", name);
    return "pub/businessNumberChk2";
  }
}
