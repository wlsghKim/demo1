package com.kh.demo1.svc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@Service
public class PublicData {

      public String getPublicData(){
    try {
//    public static void main(String[] args) throws IOException {
//        final String SERVICE_KEY = "Pns6qPIF4ThDyDFMaN1ZrvBpbg3K0hCniGPcpJ8OH9aIRIjglgxkGsV5V0LPyXt3fAxGmCBz%2BOsCS5GYsuCBaA%3D%3D";
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api/d95e5e0095b746c0ad8b/I2710/json/1/300"); /*URL*/
//        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + SERVICE_KEY ); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default: xml*/

//    urlBuilder.append("&" + URLEncoder.encode("UC_SEQ","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 ID*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        log.info("Response code: {}" ,conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        log.info("result={}" ,sb.toString());
      return sb.toString();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return  null;
    }
}

