package com.mooning.headline.service.impl;
import com.mooning.headline.dao.NewsTypeDao;
import com.mooning.headline.dao.impl.NewsTypeDaoImpl;
import com.mooning.headline.pojo.NewsType;
import com.mooning.headline.service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao typeDao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAll() {
        return typeDao.findAll();
    }
}
