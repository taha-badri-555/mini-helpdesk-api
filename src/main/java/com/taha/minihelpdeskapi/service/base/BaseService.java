package com.taha.minihelpdeskapi.service.base;

import com.taha.minihelpdeskapi.entity.BaseEntity;

public interface BaseService<T extends BaseEntity,Q > {
    T save(T entity);

    T update(T entity,Q request);

    T findById(Long id);

    T deleteById(Long id);

}
