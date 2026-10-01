package com.taha.minihelpdeskapi.service.user;

import com.taha.minihelpdeskapi.dto.user.RequestUser;
import com.taha.minihelpdeskapi.dto.user.ResponseUser;
import com.taha.minihelpdeskapi.entity.User;
import com.taha.minihelpdeskapi.exception.UserNotFoundException;
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
        return repository.findByUsername(username)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with username: " + username
                        )
                );
    }

    @Override
    public User findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException("user not found with ID: " + id));
    }


}
