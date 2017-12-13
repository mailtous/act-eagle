package com.dayi35.sys.dao;

import act.Act;
import com.dayi35.framework.dao.BeetlSqlDao;
import com.dayi35.sys.model.SysUser;
import org.osgl.util.S;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/21/17
 */
public class SysUserDao extends BeetlSqlDao<SysUser> {

    public boolean checkLogin(String userName, String pwd) {
        String pwdMd5 = Act.crypto().encrypt(pwd);
        String sql = " select count(1) from sys_user where user_name=? and pwd = ?";
        Long num = count(sql, new Object[]{userName, pwdMd5});
        return num > 0;
    }


}
