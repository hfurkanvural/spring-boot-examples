package com.hfv.controller;

import com.hfv.dto.UserDto;
import com.hfv.entity.User;
import com.hfv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(UserDto userDto)
    {
        return ResponseEntity.ok(userService.getAll());
    }
}
