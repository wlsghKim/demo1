package com.kh.demo1.svc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;

@Slf4j
@Service
public class PublicData3 {
  //    public String getPublicData() {
//      try {
  public static void main(String[] args) throws IOException {
    final String SERVICE_KEY = "bJ0AcEWnYARdHMe24EsPd77ralP%2BiRWLuhIeWgoIBgM%2F4dqlAgbS%2FilwgSiZkbkL9ojCBQHuEZI2TtoMqYzRhA%3D%3D";
    StringBuilder urlBuilder = new StringBuilder("http://api.odcloud.kr/api/nts-businessman/v1/status"); /*URL*/
    urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + SERVICE_KEY); /*Service Key*/
    urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/

    UriComponents complexUrl = UriComponentsBuilder
        .fromUriString("http://api.odcloud.kr/api/nts-businessman/v1/status")
//        .uriVariables(Map.of("nickname", "dailycode"))
        .queryParam("serviceKey", SERVICE_KEY)
        .queryParam("resultType", "JSON")
        .build();  //encode() 해주면 toUriString 사용시 한글에 대한 URL 엔코딩도 해준다

    // request url
    String url = urlBuilder.toString();

    // create an instance of RestTemplate
    RestTemplate restTemplate = new RestTemplate();

    // create headers
    HttpHeaders headers = new HttpHeaders();

    // set `Content-Type` and `Accept` headers
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // build the request
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("b_no", "1234");
    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

    // make an HTTP GET request with headers
    ResponseEntity<String> response = restTemplate.exchange(
        url,
        HttpMethod.POST,
        request,
        String.class
    );

    // check response
    if (response.getStatusCode() == HttpStatus.OK) {
      System.out.println("Request Successful.");
      System.out.println(response.getBody());
    } else {
      System.out.println("Request Failed");
      System.out.println(response.getStatusCode());
    }
  }
}
