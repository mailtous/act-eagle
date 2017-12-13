package com.dayi35.sys.dao;

import com.dayi35.framework.dao.BeetlSqlDao;
import com.dayi35.framework.page.Page;
import com.dayi35.sys.model.SysFunc;
import org.beetl.sql.core.SQLReady;

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
