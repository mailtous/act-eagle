package com.dayi35.sys.service;

import com.dayi35.framework.service.BaseServiceImpl;
import com.dayi35.framework.vo.BizRetVo;
import com.dayi35.sys.dao.SysUserDao;
import com.dayi35.sys.model.SysUser;

import javax.inject.Inject;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/21/17
 */
public class SysUserService extends BaseServiceImpl<SysUser> {

    public SysUserService(){}

    private SysUserDao sysUserDao;

    @Inject
    public SysUserService(SysUserDao userDao){
        super(userDao);
        sysUserDao = userDao;
    }

    public BizRetVo checkLogin(String userName, String pwd) {
        boolean pass = sysUserDao.checkLogin(userName, pwd);
        return pass ? new BizRetVo().setSuccess("登录成功。") : new BizRetVo().setError("用户名或密码错误!");
    }

}
