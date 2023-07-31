package com.example.springdemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

//@SpringBootTest
class SpringdemoApplicationTests {

    @Test
    public void testJwt(){//创建令牌
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"hotkey")//签名算法
                .setClaims(claims)//自定义内容，载荷
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期,这里为一个小时
                .compact();//字符串输出
        System.out.println(jwt);
    }

    @Test
    public void testhotkey(){//解析令牌
        Claims claims = Jwts.parser()
                .setSigningKey("hotkey")//令牌名
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5MDc0NjA2OH0.7u5JRXL-yvByjK0yy8rKrR2a-dNliYWFaIgW4JIrMJk")
                .getBody();//转换成string
        System.out.println(claims);
    }
}
