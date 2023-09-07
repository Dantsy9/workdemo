package com.example.utils;

import io.jsonwebtoken.Claims;
import lombok.Getter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </p>
 *
 * @author zmc
 * @since 2023-09-05
 */

public class reqInfoUtils {
    @Resource
    private static HttpServletRequest request;
    private static final String TOKEN = request.getHeader("token");
    private static final Claims CLAIMS = JwtUtils.parseJWT(TOKEN);
    @Getter
    public static String operator = CLAIMS.get("username",String.class);
    @Getter
    public static String type = CLAIMS.get("type",String.class);
    @Getter
    public static String id = CLAIMS.get("id",String.class);

}
