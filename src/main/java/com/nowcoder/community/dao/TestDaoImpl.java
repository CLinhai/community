package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by lh on 2022/8/8
 */
@Repository("mysqlImpl")
public class TestDaoImpl implements TestDao{
    @Override
    public String select() {
        return "Mysql";
    }
}
