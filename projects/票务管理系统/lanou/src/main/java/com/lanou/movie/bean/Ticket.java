package com.lanou.movie.bean;

import lombok.Data;

/**
 * @program: lanou
 * @description: 电影管理后台
 * @author: 壹零二四
 * @created: 2022/07/11 20:39
 */
@Data
public class Ticket {
    /** 序号 */
    private int id;
    /** 电影 */
    private String movie;
    /** 导演 */
    private String director;
    /** 主演 */
    private String starring;
    /** 类型 */
    private String type;
    /** 地区 */
    private String area;
    /** 语言 */
    private String language;
    /** 上映时间 */
    private String releaseTime;
}
