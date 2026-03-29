package com.mooning.headline.dao;

import com.mooning.headline.pojo.NewsHeadline;
import com.mooning.headline.pojo.vo.HeadlinePageVo;
import com.mooning.headline.pojo.vo.HeadlineQueryVo;
import com.mooning.headline.pojo.vo.HeadlineDetailVo;

import java.util.List;

public interface NewsHeadlineDao {
    List<HeadlinePageVo> finPageList(HeadlineQueryVo headlineQueryVo);

    int finPageCount(HeadlineQueryVo headlineQueryVo);


    int incrPageViews(int hid);

    HeadlineDetailVo findHeadlineDetail(int hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findByHid(Integer hid);

    int update(NewsHeadline newsHeadline);

    int removeByHid(int hid);
}
