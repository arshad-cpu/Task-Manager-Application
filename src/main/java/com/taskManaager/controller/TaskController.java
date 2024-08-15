package com.taskManaager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManaager.dto.TaskDTO;
import com.taskManaager.exception.TaskManagerException;
import com.taskManaager.service.TaskService;

@RestController
@RequestMapping(value = "/api")
@Validated
public class TaskController {

	@Autowired
    private TaskService taskService;
	
	@Autowired
	private Environment environment;
    
    @PostMapping(value = "/tasks")
    public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO) throws TaskManagerException {
         Long id=taskService.createTask(taskDTO);
         String msg=environment.getProperty("API.INSERT_SUCCESS")+ id;
         return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/taskList")
    public ResponseEntity<List<TaskDTO>>  getAllTasks() throws TaskManagerException {
    	List<TaskDTO> list= taskService.getAllTasks();
    	return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) throws TaskManagerException {
       TaskDTO dto= taskService.getTaskById(id);
       return new ResponseEntity<TaskDTO>(dto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody String title) throws TaskManagerException {
         taskService.updateTask(id,title);
         String msg=environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "tasks/{id}")
    public void deleteTask(@PathVariable Long id) throws TaskManagerException {
        taskService.deleteTask(id);
    }
}
