package util;

import io.jsonwebtoken.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @program: NewJavaWebProject
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/28 11:44
 */
public class JwtUtils {
    private static final String PRIVATE_KEY = "d8c986df-8512-42b5-906f-eeea9b3acf86";
    private static final long TIME = 1000 * 60 * 60 * 24 * 10;

    public static String toJwtToken(String userName, LocalDateTime loginTime){
        JwtBuilder jwtBuilder = Jwts.builder();
        return  jwtBuilder.setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("userName",userName)
                .claim("loginTime",loginTime)
                .setSubject("用户登陆认证")
                .setExpiration(new Date(System.currentTimeMillis()+TIME))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256,PRIVATE_KEY)
                .compact();
    }

    public static Claims fromJwtToken(String token){
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(PRIVATE_KEY).parseClaimsJws(token);
        return claimsJws.getBody();
    }
}
