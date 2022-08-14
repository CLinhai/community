package com.nowcoder.community;

import com.nowcoder.community.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lh on 2022/8/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class TransactionTests {
    @Autowired
    private TestService testService;

    @Test
    public void testSave1(){
        Object obj = testService.save1();
        System.out.println(obj);
    }
    @Test
    public void testSave2(){
        Object obj = testService.save2();
        System.out.println(obj);
    }
}
