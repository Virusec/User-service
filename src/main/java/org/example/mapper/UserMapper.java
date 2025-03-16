package org.example.mapper;

import org.example.dto.UserDto;
import org.example.model.UserApp;

import java.util.List;

/**
 * @author Anatoliy Shikin
 */
public class UserMapper {

    public static UserDto toDto(UserApp userApp) {
        return UserDto.builder()
                .id(userApp.getId())
                .firstName(userApp.getFirstName())
                .lastName(userApp.getLastName())
                .phoneNumber(userApp.getPhoneNumber())
                .build();
    }

    public static UserApp toEntity(UserDto userDto) {
        return UserApp.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phoneNumber(userDto.getPhoneNumber())
                .build();
    }

    public static List<UserDto> getAllUsers(List<UserApp> allUserApps) {
        return allUserApps.stream()
                .map(UserMapper::toDto)
                .toList();
    }

}
