package com.xm.xmap1702044.base;

import com.baomidou.framework.service.ISuperService;

public interface IBaseService<T> extends ISuperService<T> {
    PageManager query(T t, PageManager page);
    T get(T t);
    int save(T t);
    int update(T t);
    int delete(T t);
    
}
