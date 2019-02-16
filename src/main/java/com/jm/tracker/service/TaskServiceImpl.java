package com.jm.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.tracker.obj.TaskObj;
import com.jm.tracker.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<TaskObj> getTaskObjByUser(int userId) {
		// TODO Auto-generated method stub

		List<TaskObj> newTaskObj = taskRepository.findByTaskId(userId);

		// retrieve remarks here

		return newTaskObj;
	}

	@Override
	public boolean addTask(TaskObj taskObj) {
		// TODO Auto-generated method stub

		boolean result = taskRepository.save(taskObj) != null;
		return result;
	}

	@Override
	public List<TaskObj> searchTaskObjByDescription(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTask(int taskId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTask() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRemarks() {
		// TODO Auto-generated method stub
		return false;
	}

}
