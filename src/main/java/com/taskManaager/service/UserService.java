package com.taskManaager.service;

import com.taskManaager.dto.UserDTO;
import com.taskManaager.exception.TaskManagerException;

public interface UserService {

	public UserDTO createUser(UserDTO userDTO) throws TaskManagerException;
	public UserDTO findByUserId(Long id) throws TaskManagerException;
	public UserDTO updateUser(Long id, UserDTO userDTO) throws TaskManagerException;
	public void deleteUser(Long id) throws TaskManagerException;
	
}
