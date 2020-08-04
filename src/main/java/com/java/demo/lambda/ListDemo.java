package com.java.demo.lambda;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListDemo {

    @Data
    private static class UserInfo {
        private Long userId;
        private String userName;
        private Integer age;
    }

    @Test
    public void main() {

        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserInfo user = new UserInfo();
            user.setUserId((long) i);
            user.setUserName("用户" + i);
            user.setAge(20 + i);
            list.add(user);
        }

        // filter过滤
        List<UserInfo> gt20List = list.stream().filter(userInfo -> userInfo.getAge() > 20).collect(Collectors.toList());
        System.out.println(gt20List);

        // list转map
        Map<Long, UserInfo> map = list.stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        System.out.println(map);

        // 取值
        List<String> userNameList = list.stream().map(userInfo -> userInfo.getUserName()).collect(Collectors.toList());
        System.out.println(userNameList);

    }

}
