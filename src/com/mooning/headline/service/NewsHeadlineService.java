package com.mooning.headline.service;

import com.mooning.headline.pojo.NewsHeadline;
import com.mooning.headline.pojo.vo.HeadlineDetailVo;
import com.mooning.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {
    /**
     * 将参数传递给数据库进行分页查询
     * @param headlineQueryVo
     * @return
     */
    Map findPage(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo findHeadlineDetail(int hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findByHid(Integer hid);

    int update(NewsHeadline newsHeadline);

    int removeByHid(int hid);
}
