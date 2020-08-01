package com.hfv.service;

import com.hfv.dto.UserDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    void delete();

    List<UserDto> getAll();

    Page<UserDto> getAll(Pageable pageable);

}
