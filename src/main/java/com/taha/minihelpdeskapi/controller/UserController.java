package com.taha.minihelpdeskapi.controller;

import com.taha.minihelpdeskapi.dto.user.RequestUser;
import com.taha.minihelpdeskapi.dto.user.ResponseUser;
import com.taha.minihelpdeskapi.mapper.UserMapper;
import com.taha.minihelpdeskapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser requestUser) {
        var entity = userMapper.requestToEntity(requestUser);
        var save = userService.save(entity);
        var responseUser = userMapper.entityToResponse(save);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUser> getUserById(@PathVariable("id") Long id) {
        var user = userService.findById(id);
        var response = userMapper.entityToResponse(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUser> updateUser(@PathVariable("id") Long id, @RequestBody RequestUser requestUser) {
        var user = userService.findById(id);
        var update = userService.update(user, requestUser);
        var responseUser = userMapper.entityToResponse(update);
        return ResponseEntity.ok(responseUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(id);
    }

}
