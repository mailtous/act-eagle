package com.dayi35.framework.controller;

import act.app.ActionContext;
import act.controller.Controller;
import act.event.EventBus;
import act.view.RenderAny;

import javax.inject.Inject;

/**
 * Controller 基类
 * Created by leeton on 9/25/17.
 */
public class BaseController extends Controller.Util{

    @Inject
    protected ActionContext context;
    @Inject
    protected EventBus eventBus;

    /**
     * 调用模板啦
     * @param args
     * @return
     */
    public RenderAny tpl(Object... args){
        return renderTemplate(args);
    }

    /**
     * 调用模板啦
     */
    public RenderAny tpl(String path){
        context.templatePath(path);
        return renderTemplate();
    }

    /**
     * 调用模板啦
     */
    public RenderAny tpl(String path, Object... args){
        context.templatePath(path);
        return renderTemplate(args);
    }
    /**
     * 统一跳转页面
     */
    public void to(String url){
        throw Controller.Util.redirect(url);
    }
}
