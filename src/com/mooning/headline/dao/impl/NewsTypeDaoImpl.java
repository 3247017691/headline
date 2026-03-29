package com.mooning.headline.dao.impl;

import com.mooning.headline.dao.BaseDao;
import com.mooning.headline.dao.NewsTypeDao;
import com.mooning.headline.pojo.NewsType;

import java.util.List;

public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {
    @Override
    public List<NewsType> findAll() {
        String sql = "select * from news_type";
        return baseQuery(NewsType.class, sql);
    }
}
