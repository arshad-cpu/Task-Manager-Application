package com.taskManaager.service;

import java.util.List;

import com.taskManaager.dto.TaskDTO;
import com.taskManaager.exception.TaskManagerException;

public interface TaskService {
	
    public Long createTask(TaskDTO taskDTO) throws TaskManagerException;
    
    public List<TaskDTO> getAllTasks() throws TaskManagerException ;
    
    public TaskDTO getTaskById(Long id) throws TaskManagerException;
    
    public void updateTask(Long id, String title) throws TaskManagerException;
    
    public void deleteTask(Long id) throws TaskManagerException;
}
