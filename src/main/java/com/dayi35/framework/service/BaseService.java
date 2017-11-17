package com.dayi35.framework.service;

import com.dayi35.framework.page.Page;

import java.util.List;

/**
 * Created by leeton on 10/10/17.
 */
public interface BaseService<T> {

    T get(Long id);

    int save(T t);

    int update(T t);

    int delete(T t);

    int delete(Long id);

    List<T> getList(String sql);

    List<T> getList(String frameSql, Object... args);

    Page<T> getPage(Page page, String frameSql, Object[] args);


}
