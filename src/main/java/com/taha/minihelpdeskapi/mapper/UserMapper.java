package com.taha.minihelpdeskapi.mapper;

import com.taha.minihelpdeskapi.dto.user.RequestUser;
import com.taha.minihelpdeskapi.dto.user.ResponseUser;
import com.taha.minihelpdeskapi.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @org.mapstruct.Builder(disableBuilder = true))
public interface UserMapper extends BaseMapper<RequestUser, ResponseUser, User>{

    @Override
    RequestUser entityToRequest(User entity);

    @Override
    User requestToEntity(RequestUser dto);

    @Override
    void updateEntityWithRequest(RequestUser dto, @MappingTarget User entity);

    @Override
    User responseToEntity(ResponseUser dto);

    @Override
    ResponseUser entityToResponse(User entity);
}
