package com.taha.minihelpdeskapi.service.user;

import com.taha.minihelpdeskapi.dto.user.RequestUser;
import com.taha.minihelpdeskapi.dto.user.ResponseUser;
import com.taha.minihelpdeskapi.entity.User;
import com.taha.minihelpdeskapi.mapper.UserMapper;
import com.taha.minihelpdeskapi.repository.UserRepository;
import com.taha.minihelpdeskapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<
        User,
        RequestUser,
        ResponseUser,
        UserMapper,
        UserRepository>
        implements UserService {
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public User findByUsername(String username) {
        var present = repository.findByUsername(username);
        return present.orElseThrow(NullPointerException::new);
    }
}
