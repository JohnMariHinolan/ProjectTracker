package com.jm.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.tracker.obj.TaskObj;

@Repository
public interface TaskRepository extends JpaRepository<TaskObj, Integer> {

	List<TaskObj> findByTaskId(int taskId);
}
