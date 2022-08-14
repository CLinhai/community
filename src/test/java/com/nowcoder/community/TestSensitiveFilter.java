package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
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
public class TestSensitiveFilter {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter(){
        String text = "陈林海,邓孜怡,这里有笨蛋!";
         text = sensitiveFilter.filter(text);
        System.out.println(text);
        text = "陈@林@海@,邓@孜@怡@";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

    }
}
