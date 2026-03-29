package com.mooning.headline.service.impl;
import com.mooning.headline.dao.NewsUserDao;
import com.mooning.headline.dao.impl.NewsUserDaoImpl;
import com.mooning.headline.pojo.NewsUser;
import com.mooning.headline.service.NewsUserService;
import com.mooning.headline.util.MD5Util;

public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao userDao = new NewsUserDaoImpl();
    @Override
    public NewsUser finByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public NewsUser finByUid(Integer userId) {
        return userDao.findByUid(userId);
    }

    @Override
    public Integer registUser(NewsUser registUser) {
        //处理CRUD业务
        //将明文密码转换成密文密码
        registUser.setUserPwd(MD5Util.encrypt(registUser.getUserPwd()));
        return userDao.insertUser(registUser);

    }
}
