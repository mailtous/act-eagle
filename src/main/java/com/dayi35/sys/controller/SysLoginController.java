package com.dayi35.sys.controller;

import act.controller.annotation.TemplateContext;
import act.controller.annotation.UrlContext;
import act.view.RenderAny;
import com.dayi35.framework.controller.BaseController;
import com.dayi35.framework.vo.BizRetVo;
import org.osgl.http.H;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PostAction;
import org.osgl.mvc.result.RenderJSON;

/**
 * Function:
 *
 * @Autor: leeton
 * @Date : 11/20/17
 */
@UrlContext("/sys/login")
@TemplateContext("/sys/login")
public class SysLoginController extends BaseController {

    @GetAction("")
    public RenderAny index(H.Request req) {
        return tpl("sys_login_index.html");
    }

    @GetAction("1")
    public RenderJSON loginPost(H.Request req) {

        return json(new BizRetVo<>());
    }

}
