package com.cpy.tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 测试jwt令牌的生成
     */
    @Test
    public void testJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"cpyN")  //签名算法，加盐，加盐必须长度超过四位
                .setClaims(claims) // 自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis()+ 3600*1000))  // 设置有效期为1h
                .compact();
        System.out.println(jwt);

    }

    /**
     * 测试jwt解析
     */
    @Test
    public void jwtParse(){
        Claims claims = Jwts.parser()
                .setSigningKey("cpyN") // jwt密钥
                // jwt令牌
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcyNzM2NjcxOH0.psqA004fprApQRayG-C9N4z6caa4i_4FSzBn7fA4QL4")
                .getBody();
        System.out.println(claims);
    }
}
