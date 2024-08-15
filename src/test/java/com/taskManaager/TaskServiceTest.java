package com.taskManaager;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.taskManaager.dto.TaskDTO;
import com.taskManaager.entity.Task;
import com.taskManaager.entity.User;
import com.taskManaager.exception.TaskManagerException;
import com.taskManaager.respository.TaskRepository;
import com.taskManaager.service.TaskService;
import com.taskManaager.service.UserService;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

	 @Mock
	    private TaskRepository taskRepository;
	    @Mock
	    private UserService userService;

	    @InjectMocks
	    private TaskService taskService;

	    private TaskDTO taskDTO;
	    private User user;

	    @Before
	    public void setup() {
	    	taskDTO = new TaskDTO();
	    	taskDTO.setId(1L);
	    	taskDTO.setTitle("Test Task");
	    	taskDTO.setDescription(null);
	    	taskDTO.setStatus(null);
	    	

	        user = new User();
	        user.setUserId(1L);
	        user.setFirstName("John");
	        user.setLastName("Doe");
	        user.setTimeZone("PST");
	        user.setActive(true);
	    }

//	    @Test
//	    public void testCreateTask() {
//	        when(taskRepository.save(taskDTO)).thenReturn(taskDTO);
//	        when(userService.createUser(user)).thenReturn(user);
//
//	        Long createdTask = taskService.createTask(taskDTO);
//	        assertNotNull(createdTask);
//	        assertEquals(taskDTO.getTitle(), createdTask.);
//	        verify(taskRepository).save(null);
//	    }
//
//	    @Test
//	    public void testUpdateTask() {
//	        when(taskRepository.findById(1L)).thenReturn(Optional.of(null));
//	        
//
//	        updatedTask = taskService.updateTask(1L, null);
//	        assertNotNull(updatedTask);
//	        assertEquals(taskDTO.getTitle(), updatedTask.getTitle());
//	        verify(taskRepository).findById(1L);
//	        
//	    }

	    @Test
	    public void testDeleteTask() throws TaskManagerException {
	        when(taskRepository.findById(1L)).thenReturn(Optional.of(null));

	        taskService.deleteTask(1L);
	        verify(taskRepository).findById(1L);
	        
	    }

	    @Test(expected = TaskManagerException.class)
	    public void testDeleteTask_TaskNotFound() throws TaskManagerException {
	        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

	        taskService.deleteTask(1L);
	    }

	    @Test(expected = TaskManagerException.class)
	    public void testUpdateTask_TaskNotFound() throws TaskManagerException {
	        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

	        taskService.updateTask(1L, null);
	    }
	
}
