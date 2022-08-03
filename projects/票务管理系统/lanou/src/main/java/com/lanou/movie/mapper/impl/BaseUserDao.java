package com.lanou.movie.mapper.impl;

import com.lanou.movie.util.DataUtil;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/12 09:36
 */
public abstract class BaseUserDao {
    protected QueryRunner runner;

    public BaseUserDao(){
        runner = new QueryRunner(DataUtil.getUserSource());
    }
}
