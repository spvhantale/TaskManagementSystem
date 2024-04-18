package com.task.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.Priority;
import com.task.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer>{

	public List<Task> findByPriorityAndDueDateAndCompleted(Priority priority,LocalDateTime dueDate,boolean completed);
	public List<Task> findByPriority(Priority priority);
    
	public List<Task> findByDueDate(LocalDateTime dueDate);
    
	public List<Task> findByCompleted(boolean completed);

	public List<Task> findAllByOrderByPriorityAsc();

	public List<Task> findAllByOrderByDueDateAsc();
}
