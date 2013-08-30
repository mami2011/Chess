package com.vendertool.fps.dal.task;

import java.util.List;

import com.vendertool.fps.dal.job.Job;


public interface TaskDao {

	void insert (Task task);

	void update(Task task);

	void delete(Task task);
	List<Task> findByJobId(long jobId);
	List<Task> findByTaskId(long accountId);
		
}
