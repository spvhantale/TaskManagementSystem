package com.task.service;

import java.time.LocalDateTime;
import java.util.List;

import com.task.exception.TaskException;
import com.task.exception.UserException;
import com.task.model.Priority;
import com.task.model.Task;

public interface TaskService {

	public Task saveTask(Task task,Integer userId) throws UserException;
	public Task updateTask(Task task,Integer userId) throws UserException,TaskException;
	public Task markAsCompleted(Integer taskId) throws TaskException;
	public List<Task> filterTasks(Priority priority,LocalDateTime dueDate,boolean completed) throws TaskException;
	public List<Task> sortTaskByPriority();
	public List<Task> sortTaskByDueDate();
}
