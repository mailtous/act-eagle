package com.artlongs.sys.dao;

import com.artlongs.framework.dao.BeetlSqlDao;
import com.artlongs.framework.page.Page;
import com.artlongs.sys.model.SysFunc;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/21/17
 */
public class SysFuncDao extends BeetlSqlDao<SysFunc> {


    public Page<SysFunc> getAllOfPage(Page page){
        String sql = " select * from sys_func";
        return getPage(page, sql, null);
    }

    public boolean realDelFunc(Long funcId) {
        int num = delete(funcId);
        return num > 0;
    }
}
