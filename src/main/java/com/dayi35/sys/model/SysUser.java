package com.dayi35.sys.model;


import com.dayi35.framework.model.BaseEntity;
import javax.persistence.Entity;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/21/17
 */
@Entity
public class SysUser extends BaseEntity {

    private String userName;
    private String pwd;
    private Long roleId;
    private Long deptId;
    private Integer delStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }
}
