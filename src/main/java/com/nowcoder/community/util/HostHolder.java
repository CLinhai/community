package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by lh on 2022/8/12
 * 持有用户信息,线程隔离级别的,代替服务器的session
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
       return users.get();
    }

    public void clear() {
        users.remove();
    }

}
