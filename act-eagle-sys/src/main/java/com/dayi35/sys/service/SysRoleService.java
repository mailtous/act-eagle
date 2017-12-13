package com.dayi35.sys.service;

import com.dayi35.framework.dao.BaseDao;
import com.dayi35.framework.service.BaseServiceImpl;
import com.dayi35.sys.dao.SysRoleDao;
import com.dayi35.sys.model.SysFunc;
import com.dayi35.sys.model.SysRole;

import javax.inject.Inject;
import java.util.List;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/29/17
 */
public class SysRoleService extends BaseServiceImpl<SysRole> {

    public SysRoleService(){}

    private SysRoleDao sysRoleDao;

    public SysRoleService(SysRoleDao sysRoleDao) {
        this.sysRoleDao = sysRoleDao;
        this.baseDao = sysRoleDao;
    }
}
