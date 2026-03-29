package com.mooning.headline.service;

import com.mooning.headline.pojo.NewsUser;

public interface NewsUserService {
    /**
     * 根据用户登陆的账户查询单个user的方法
     * @param username 用户输入的账号
     * @return  找到用户返回的NewsUser对象，找不到返回NULL
     */
    NewsUser finByUsername(String username);

    NewsUser finByUid(Integer userId);

    /**
     * 根据用户的账号信息注册
     * @param registUser
     * @return
     */
    Integer registUser(NewsUser registUser);
}
