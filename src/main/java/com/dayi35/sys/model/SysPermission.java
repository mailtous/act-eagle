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
    private String funcListJson; //json

    @Transient
    private transient List<FuncVo> funcList = C.newList();


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getFuncListJson() {
        return funcListJson;
    }

    public void setFuncListJson(String funcListJson) {
        this.funcListJson = funcListJson;
    }

    @Transient
    public List<FuncVo> getFuncList() {
        List<FuncVo> funcs = C.newList();
        if(S.isNotBlank(this.funcListJson)){
            funcs = JSON.parseObject(funcListJson, List.class);
        }
        return funcs;
    }

    public void setFuncList(List<FuncVo> funcList) {
        this.funcList = funcList;
    }


}
