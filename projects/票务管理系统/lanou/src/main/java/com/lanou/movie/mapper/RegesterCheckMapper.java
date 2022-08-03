package com.lanou.movie.mapper;

/**
 * @author WANG
 * @date 2022年07月12日 10:44
 */
public interface RegesterCheckMapper {
    /** 校验用户名是否合法 */
    boolean checkName(String username);
    /** 校验密码是否合法 */
    boolean checkPassword(String password);
    /** 校验手机号是否合法 */
    boolean checkPhone(String phone);
    /** 校验邮箱是否合法 */
    boolean checkEmail(String email);
    /** 校验用户名是否存在 */
    boolean hasExists(String username);
}
