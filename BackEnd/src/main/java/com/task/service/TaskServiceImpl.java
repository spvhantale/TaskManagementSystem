package com.task.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.task.exception.TaskException;
import com.task.exception.UserException;
import com.task.model.Priority;
import com.task.model.Task;
import com.task.repo.TaskRepo;
import com.task.repo.UserRepo;

public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepo taskRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public Task saveTask(Task task, Integer userId) throws UserException {
		
		return null;
	}

	@Override
	public Task updateTask(Task task, Integer userId) throws UserException, TaskException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task markAsCompleted(Integer taskId) throws TaskException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> filterTasks(Priority priority, LocalDateTime dueDate, boolean completed) throws TaskException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> sortTaskByPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> sortTaskByDueDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
