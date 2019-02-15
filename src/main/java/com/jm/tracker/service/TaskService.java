package com.jm.tracker.service;

import java.util.List;

import com.jm.tracker.obj.TaskObj;

public interface TaskService {

	public List<TaskObj> getTaskObjByUser(int userId);

	public List<TaskObj> searchTaskObjByDescription(String text);

	public boolean addTask(TaskObj taskObj);

	public boolean deleteTask(int taskId);

	public boolean updateTask();

	public boolean addRemarks();

}
