package com.dayi35.sys.model;

import com.alibaba.fastjson.JSON;
import com.dayi35.framework.model.BaseEntity;
import org.osgl.util.C;
import org.osgl.util.S;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/21/17
 */
@Entity
public class SysPermission extends BaseEntity {

    private Long roleId;
    private Long funcId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }
}
