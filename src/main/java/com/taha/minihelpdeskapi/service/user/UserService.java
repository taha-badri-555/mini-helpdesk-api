package com.taha.minihelpdeskapi.service.user;

import com.taha.minihelpdeskapi.dto.user.RequestUser;
import com.taha.minihelpdeskapi.entity.User;
import com.taha.minihelpdeskapi.service.base.BaseService;

public interface UserService extends BaseService<User, RequestUser> {
    User findByUsername(String username);
}
