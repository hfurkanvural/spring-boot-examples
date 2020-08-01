package com.hfv.service.impl;

import com.hfv.dto.UserDto;
import com.hfv.entity.Address;
import com.hfv.entity.User;
import com.hfv.repo.AddressRepository;
import com.hfv.repo.UserRepository;
import com.hfv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto.getName(), "Name is required!" );

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userDb = userRepository.save(user);
        List<Address> list = new ArrayList<>();

        userDto.getAddressList().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setStatus(true);
            address.setUser(userDb);
            list.add(address);
        });

        addressRepository.saveAll(list);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(item -> {
            UserDto userDto = new UserDto();
            userDto.setId(item.getId());
            userDto.setName(item.getName());
            userDto.setSurname(item.getSurname());
            userDto.setAddressList(item.getAddressList().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
