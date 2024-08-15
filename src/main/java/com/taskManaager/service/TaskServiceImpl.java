package com.taskManaager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskManaager.dto.TaskDTO;
import com.taskManaager.entity.Task;
import com.taskManaager.exception.TaskManagerException;
import com.taskManaager.respository.TaskRepository;

@Service(value = "taskService")
@Transactional
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository  taskRepository;
	
	@Override
	public Long createTask(TaskDTO taskDTO) throws TaskManagerException {
		// TODO Auto-generated method stub
		Optional<Task> optional = taskRepository.findById(taskDTO.getId());
		if (optional.isPresent())
			throw new TaskManagerException("Service.TASK_FOUND");
		Task task = new Task();
		task.setId(taskDTO.getId());
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setStatus(taskDTO.getStatus());
		task.setCreatedAt(taskDTO.getCreatedAt());
		task.setUpdatedAt(taskDTO.getUpdatedAt());
		taskRepository.save(task);
		return task.getId();
		
	}

	@Override
	public List<TaskDTO> getAllTasks() throws TaskManagerException {
		List<Task> tasks = taskRepository.findAll();
		List<TaskDTO> taskDTOs = new ArrayList<>();
		if(tasks.isEmpty()) {
			throw new TaskManagerException("Service.TASK_NOT_FOUND");
		}
		tasks.forEach(task -> {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setId(task.getId());
			taskDTO.setTitle(task.getTitle());
			taskDTO.setDescription(task.getDescription());
			taskDTO.setStatus(task.getStatus());
			taskDTO.setCreatedAt(task.getCreatedAt());
			taskDTO.setUpdatedat(task.getCreatedAt());
			taskDTOs.add(taskDTO);
		});
		return taskDTOs;
	}
	

	@Override
	public TaskDTO getTaskById(Long id) throws TaskManagerException {
		// TODO Auto-generated method stub
		Optional<Task> optional = taskRepository.findById(id);
		Task task = optional.orElseThrow(() -> new TaskManagerException("Service.TASK_NOT_FOUND"));
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setId(task.getId());
		taskDTO.setTitle(task.getTitle());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setStatus(task.getStatus());
		taskDTO.setCreatedAt(task.getCreatedAt());
		taskDTO.setUpdatedat(task.getCreatedAt());
		return taskDTO;
		
	}

	@Override
	public void updateTask(Long id, String title) throws TaskManagerException {
		Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setTitle(title);
            taskRepository.save(existingTask);
        } else {
            throw new TaskManagerException("Service.Task_NOT_FOUND");
        }
		
	}

	@Override
	public void deleteTask(Long id) throws TaskManagerException {
		// TODO Auto-generated method stub
		
		taskRepository.deleteById(id);
		
	}

}
