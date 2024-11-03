package com.example;

import java.util.Arrays;
import java.util.List;

import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import com.alibaba.fastjson.JSONArray;



@RequestMapping("/index")
@RestController
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping("/api")
    String hello() {
        return "Hello World!";
    }
    @GetMapping("/cal")
    public JSONArray calString(@RequestParam String para1,@RequestParam String para2) {
       
        //Arrays.asList(para1, para2).toString()
JSONArray array = JSONArray.parseArray(Arrays.asList(para1, para2).toString());
      //  String  _json = JSON.toJSONString( Arrays.asList(para1, para2))
        return array;
    }

    @Data
    static class Result {
        private final int left;
        private final int right;
        private final long answer;
    }




}
