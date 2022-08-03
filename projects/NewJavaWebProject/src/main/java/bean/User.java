package bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: NewJavaWebProject
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/21 19:50
 */

@Data
public class User {
    private int uid;
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime reTime;
    private String address;
}
