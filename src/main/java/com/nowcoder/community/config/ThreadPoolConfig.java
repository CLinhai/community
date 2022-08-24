package com.nowcoder.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by lh on 2022/8/23
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig{
}
