package com.dayi35.sys.controller;

import act.controller.annotation.TemplateContext;
import act.controller.annotation.UrlContext;
import act.view.RenderAny;
import com.dayi35.framework.controller.BaseController;
import com.dayi35.framework.model.BaseEntity;
import com.dayi35.framework.page.Page;
import com.dayi35.framework.vo.BizRetVo;
import com.dayi35.sys.model.SysUser;
import com.dayi35.sys.service.SysUserService;
import org.osgl.http.H;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.Param;
import org.osgl.mvc.annotation.PostAction;
import org.osgl.mvc.result.RenderJSON;

import javax.inject.Inject;
import java.util.Date;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/22/17
 */
@UrlContext("/sys/user")
@TemplateContext("/sys/user")
public class SysUserController extends BaseController {

    @Inject
    private SysUserService sysUserService;

    @GetAction("list")
    public RenderAny list(Integer pageNo) {
        Page<SysUser> page = new Page<>().setPageNo(pageNo);
        String sql = " select * from sys_user";
        page = sysUserService.getPage(page, sql, null);
        render(page);
        return tpl("list.html");
    }

    @PostAction("add")
    public RenderJSON add(SysUser sysUser) {
        sysUser.setCreateDate(new Date());
        sysUserService.save(sysUser);
        return json(new BizRetVo<>().setSuccess("系统用户添加成功!"));
    }

    @PostAction("edit/{id}")
    public RenderJSON edit(SysUser sysUser) {
        sysUserService.update(sysUser);
        return json(new BizRetVo<>().setSuccess("用户资料编辑成功!"));
    }

    @PostAction("del/{id}")
    public RenderJSON del(Long sysUserId) {
        SysUser sysUser = sysUserService.get(sysUserId);
        if (null != sysUser) {
//            sysUser.setDelStatus(BaseEntity.DELETED);
        }
        return json(new BizRetVo<>().setSuccess("用户删除成功!"));
    }


}
