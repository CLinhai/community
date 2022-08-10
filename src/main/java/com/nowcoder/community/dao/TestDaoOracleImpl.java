package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by lh on 2022/8/8
 */
@Repository
@Primary
public class TestDaoOracleImpl implements TestDao{
    @Override
    public String select() {
        return "Oracle";
    }
}
