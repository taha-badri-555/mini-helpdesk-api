package com.taha.minihelpdeskapi.mapper;

import com.taha.minihelpdeskapi.entity.BaseEntity;
import org.mapstruct.MappingTarget;

public interface BaseMapper<REQUEST, RESPONSE, T extends BaseEntity> {

    REQUEST entityToRequest(T entity);

    T requestToEntity(REQUEST dto);

    void updateEntityWithRequest(REQUEST dto, @MappingTarget T entity);

    T responseToEntity(RESPONSE dto);

    RESPONSE entityToResponse(T entity);

}
