package com.mooning.headline.dao;

import com.mooning.headline.pojo.NewsUser;

public interface NewsUserDao {
    NewsUser findByUsername(String username);

    NewsUser findByUid(Integer userId);

    Integer insertUser(NewsUser registUser);
}
