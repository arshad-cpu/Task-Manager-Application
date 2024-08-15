package com.taskManaager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskManaager.dto.UserDTO;
import com.taskManaager.entity.User;
import com.taskManaager.exception.TaskManagerException;
import com.taskManaager.respository.UserRepository;
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;

	@Override
    public UserDTO createUser(UserDTO userDTO) throws TaskManagerException{
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setTimeZone(userDTO.getTimeZone());
        user.setActive(userDTO.isActive());
        user = userRepository.save(user);
        userDTO.setUserId(user.getUserId());
        return userDTO;
    }

	@Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) throws TaskManagerException{
        User user = userRepository.findById(userId).orElseThrow();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setTimeZone(userDTO.getTimeZone());
        user.setActive(userDTO.isActive());
        user = userRepository.save(user);
        userDTO.setUserId(user.getUserId());
        return userDTO;
    }

	@Override
    public void deleteUser(Long userId) throws TaskManagerException{
        userRepository.deleteById(userId);
    }

	@Override
    public UserDTO findByUserId(Long userId) throws TaskManagerException {
        Optional<User> optional = userRepository.findById(userId);
        User user = optional.orElseThrow(() -> new TaskManagerException("Service.USER_NOT_FOUND"));
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());;
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setTimeZone(user.getTimeZone());
        userDTO.setActive(true);;
        return userDTO;
    }
}
