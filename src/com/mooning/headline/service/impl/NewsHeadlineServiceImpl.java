package com.mooning.headline.service.impl;
import com.mooning.headline.dao.NewsHeadlineDao;
import com.mooning.headline.dao.impl.NewsHeadlineDaoImpl;
import com.mooning.headline.pojo.NewsHeadline;
import com.mooning.headline.pojo.vo.HeadlineDetailVo;
import com.mooning.headline.pojo.vo.HeadlinePageVo;
import com.mooning.headline.pojo.vo.HeadlineQueryVo;
import com.mooning.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private NewsHeadlineDao headlineDao = new NewsHeadlineDaoImpl();
    @Override
    public Map findPage(HeadlineQueryVo headlineQueryVo) {
        int pageNum = headlineQueryVo.getPageNum() == null || headlineQueryVo.getPageNum() < 1 ? 1 : headlineQueryVo.getPageNum();
        int pageSize = headlineQueryVo.getPageSize() == null || headlineQueryVo.getPageSize() < 1 ? 10 : headlineQueryVo.getPageSize();
        headlineQueryVo.setPageNum(pageNum);
        headlineQueryVo.setPageSize(pageSize);
        List<HeadlinePageVo> pageData = headlineDao.finPageList(headlineQueryVo);
        int totalSize = headlineDao.finPageCount(headlineQueryVo);

        int totalPage =  totalSize % pageSize ==0?totalSize/pageSize:totalSize/pageSize+1;
        Map pageInfo = new HashMap();
        pageInfo.put("pageNum",pageNum);
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("totalSize",totalSize);
        pageInfo.put("totalPage",totalPage);
        pageInfo.put("pageData",pageData);
        return pageInfo;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(int hid) {
        headlineDao.incrPageViews(hid);
        return headlineDao.findHeadlineDetail(hid);
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        return headlineDao.addNewsHeadline(newsHeadline);
    }

    @Override
    public NewsHeadline findByHid(Integer hid) {
        return headlineDao.findByHid(hid);
    }

    @Override
    public int update(NewsHeadline newsHeadline) {
        return headlineDao.update(newsHeadline);
    }

    @Override
    public int removeByHid(int hid) {
        return  headlineDao.removeByHid(hid);
    }

}
