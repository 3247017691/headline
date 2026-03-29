package com.mooning.headline.dao;

import com.mooning.headline.pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {
    /**
     * 查询所有新闻分类信息
     *
     * @return 返回包含所有新闻分类的 List 集合，每个元素为 NewsType 对象
     */
    List<NewsType> findAll();
}
