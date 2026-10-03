package com.taha.minihelpdeskapi.service.user;

import com.taha.minihelpdeskapi.dto.user.RequestUser;
import com.taha.minihelpdeskapi.dto.user.ResponseUser;
import com.taha.minihelpdeskapi.entity.User;
import com.taha.minihelpdeskapi.exception.UserNotFoundException;
import com.taha.minihelpdeskapi.mapper.UserMapper;
import com.taha.minihelpdeskapi.repository.UserRepository;
import com.taha.minihelpdeskapi.service.base.BaseServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public User update(User user, RequestUser request) {

        mapper.updateEntityWithRequest(request, user);

        if (request.password() != null && !request.password().isBlank()) {
            user.setPassword(
                    passwordEncoder.encode(request.password())
            );
        }

        return repository.save(user);
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
