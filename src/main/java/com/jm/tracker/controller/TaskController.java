package com.jm.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jm.tracker.obj.TaskObj;
import com.jm.tracker.service.TaskService;

@RestController
public class TaskController {
	@Autowired
	TaskService taskService;

	@GetMapping("/task/{id}")
	public List<TaskObj> getTasks(@PathVariable("id") int id) {

		return taskService.getTaskObjByUser(id);

	}

	@PostMapping(path = "/task/add", consumes = "application/json", produces = "application/json")
	public boolean addTask(@RequestBody TaskObj taskObj) {

		return taskService.addTask(taskObj);

	}

}
