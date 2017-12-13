package com.dayi35.sys.service;

import com.dayi35.framework.dao.BaseDao;
import com.dayi35.framework.page.Page;
import com.dayi35.framework.service.BaseServiceImpl;
import com.dayi35.sys.dao.SysFuncDao;
import com.dayi35.sys.model.SysFunc;

import javax.inject.Inject;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/29/17
 */
public class SysFuncService extends BaseServiceImpl<SysFunc> {


    private SysFuncDao sysFuncDao;

    @Inject
    public SysFuncService(SysFuncDao sysFuncDao) {
        this.baseDao = sysFuncDao;
        this.sysFuncDao = sysFuncDao;
    }

    @Inject
    private SysPermissionService sysPermissionService;

    public Page<SysFunc> getAllOfPage(Page page){
        return sysFuncDao.getAllOfPage(page);

    }

    public boolean realDelFuncAndPermisson(Long funcId) {
       if(sysFuncDao.realDelFunc(funcId)){
           return sysPermissionService.realDelByFuncId(funcId);
        }
        return false;
    }

}
