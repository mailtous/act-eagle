package com.dayi35.sys;

import act.controller.annotation.TemplateContext;
import act.controller.annotation.UrlContext;
import act.view.RenderAny;
import com.dayi35.framework.controller.BaseController;
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
@UrlContext("/sys")
@TemplateContext("/sys")
public class SysLogin extends BaseController {

    @GetAction("login")
    public RenderAny index(H.Request req) {
        return tpl("sys_login_index.html");
    }

    @PostAction("login/post")
    public RenderJSON loginPost(H.Request req) {

        return json("ok");
    }

}
