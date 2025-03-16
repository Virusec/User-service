package org.example.service;

import org.example.dto.UserDto;

import java.util.List;

/**
 * @author Anatoliy Shikin
 */
public interface UserService {
    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);

    UserDto getUserById(Long id);

    UserDto getUserByLastName(String lastName);

    List<UserDto> getAllUsers();

}
