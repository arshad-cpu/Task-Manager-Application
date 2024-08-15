package com.taskManaager.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskManaager.entity.Task;
import com.taskManaager.entity.User;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);
}
