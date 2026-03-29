package com.mooning.headline.controller;
import com.mooning.headline.common.Result;
import com.mooning.headline.pojo.NewsHeadline;
import com.mooning.headline.pojo.NewsType;
import com.mooning.headline.pojo.vo.HeadlineDetailVo;
import com.mooning.headline.pojo.vo.HeadlineQueryVo;
import com.mooning.headline.service.NewsHeadlineService;
import com.mooning.headline.service.NewsTypeService;
import com.mooning.headline.service.impl.NewsHeadlineServiceImpl;
import com.mooning.headline.service.impl.NewsTypeServiceImpl;
import com.mooning.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户控制器
 * 门户页的请求
 */

@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private NewsTypeService typeService = new NewsTypeServiceImpl();
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();


    /**
     * 根据分页查询头条信息的接口实现
     * pageData:[]
     * pageNum:1
     * pageSize:1
     * totalPage:1
     * totalSize:1
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求中的参数
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        //将参数传递给服务层 进行分页查询
        Map pageInfo = headlineService.findPage(headlineQueryVo);
        Map data = new HashMap();
        data.put("pageInfo",pageInfo);
        //将分页查询的结果响应转换为JSON响应给客户端
        WebUtil.writeJson(resp,Result.ok(data));
    }

    /**
     * 查询所有的头条业务要求接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有类型
        List<NewsType> newsTypeList = typeService.findAll();

        WebUtil.writeJson(resp,Result.ok(newsTypeList));
    }

    /**
     * 查询头条详情接口实现
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int hid = Integer.parseInt(req.getParameter("hid"));
        HeadlineDetailVo headlineDetailVo = headlineService.findHeadlineDetail(hid);
        Map data = new HashMap();
        data.put("headline",headlineDetailVo);
        WebUtil.writeJson(resp,Result.ok(data));
    }
}
