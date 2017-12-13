package com.dayi35.sys.service;

import com.dayi35.framework.service.BaseServiceImpl;
import com.dayi35.sys.dao.SysPermissionDao;
import com.dayi35.sys.model.SysPermission;
import org.osgl.util.C;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/29/17
 */
public class SysPermissionService extends BaseServiceImpl<SysPermission> {

    private SysPermissionDao sysPermissionDao;

    @Inject
    public SysPermissionService(SysPermissionDao sysPermissionDao) {
        baseDao = sysPermissionDao;
        this.sysPermissionDao = sysPermissionDao;
    }

    public List<SysPermission> getPermissionList(Integer roleId) {
        List<SysPermission> permissionList = sysPermissionDao.getPermissionListByRoleid(roleId);

        return permissionList;
    }

    public boolean realDelByFuncId(Long funcId) {
        return sysPermissionDao.realDelByFuncId(funcId);
    }


}
