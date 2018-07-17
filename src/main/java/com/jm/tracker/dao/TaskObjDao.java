package com.jm.tracker.dao;

import com.jm.tracker.obj.ResultObj;
import com.jm.tracker.obj.TaskObj;

public interface TaskObjDao {

	
		public TaskObj getTask(String userName, String passWord);
		
		public TaskObj updateTask(String userId, TaskObj taskObj );
		
		public ResultObj deleteTask(String userId);
		
		public ResultObj createTask(TaskObj userObj);
	
		public void adjustTime();
}
