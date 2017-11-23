package com.dayi35.sys.service;

import com.dayi35.framework.service.BaseServiceImpl;
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

    @Inject
    public SysUserService(SysUserDao userDao){
        super(userDao);
    }

}
