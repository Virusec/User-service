package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.mapper.UserMapper;
import org.example.model.UserApp;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anatoliy Shikin
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        UserApp userApp = UserMapper.toEntity(userDto);
        return UserMapper.toDto(userRepository.save(userApp));
    }

    @Override
    public UserDto update(UserDto userDto) {
        UserApp userApp = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("user with " + userDto.getId() + " not found"));
        userApp.setId(userDto.getId());
        userApp.setFirstName(userDto.getFirstName());
        userApp.setLastName(userDto.getLastName());
        userApp.setPhoneNumber(userDto.getPhoneNumber());
        return UserMapper.toDto(userApp);
    }

    @Override
    public void delete(Long id) {
        UserApp userApp = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user with " + id + " not found"));
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Long id) {
        UserApp userApp = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user with " + id + " not found"));
        return UserMapper.toDto(userApp);
    }

    @Override
    public UserDto getUserByLastName(String lastName) {
        UserApp userApp = userRepository.findUserByLastNameIgnoreCase(lastName)
                .orElseThrow(() -> new IllegalArgumentException("user with " + lastName + " not found"));
        return UserMapper.toDto(userApp);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserApp> all = userRepository.findAll();
        return UserMapper.getAllUsers(all);
    }

}
