package com.kh.demo1.json;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JsonToJavaTest {
  @Test
  void test1(){
    String json = "{\n" +
        "    \"request_cnt\": 1,\n" +
        "    \"match_cnt\": 1,\n" +
        "    \"status_code\": \"OK\",\n" +
        "    \"data\": [\n" +
        "        {\n" +
        "            \"b_no\": \"6212002123\",\n" +
        "            \"b_stt\": \"계속사업자\",\n" +
        "            \"b_stt_cd\": \"01\",\n" +
        "            \"tax_type\": \"부가가치세 간이과세자\",\n" +
        "            \"tax_type_cd\": \"02\",\n" +
        "            \"end_dt\": \"\",\n" +
        "            \"utcc_yn\": \"N\",\n" +
        "            \"tax_type_change_dt\": \"20000701\",\n" +
        "            \"invoice_apply_dt\": \"\"\n" +
        "        }\n" +
        "    ]\n" +
        "}";

    Root r = new Root();
    r.setRequest_cnt(1);
    int request_cnt = r.getRequest_cnt();
  }

  @Data  //toString(), getter(), setter(), equals(), hashCode()
  public class Root{
    private int request_cnt;
    private int match_cnt;
    private String status_code;
    private ArrayList<Datum> data;
  }

  @Data
  public class Datum{
    private String b_no;
    private String b_stt;
    private String b_stt_cd;
    private String tax_type;
    private String tax_type_cd;
    private String end_dt;
    private String utcc_yn;
    private String tax_type_change_dt;
    private String invoice_apply_dt;
  }
}
