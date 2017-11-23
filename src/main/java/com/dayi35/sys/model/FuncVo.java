package com.dayi35.sys.model;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/21/17
 */
public class FuncVo{
    private Integer id;
    private Integer parentId;
    private String funcName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
}