package com.vendertool.fps.dal.job;

import java.util.List;

import com.vendertool.fps.dal.file.File;


public interface JobDao {

	void insert (Job job);

	void update(Job job);

	void delete(Job job);
	List<Job> findByJobId(long jobId);
	List<Job> findByAccountId(long accountId);
	List<Job> findByAccountIdAndReqFileGroupId(long accountId,String reqFileGroupId);
	List<Job> findByAccountIdAndResFileGroupId(long accountId,String resFileGroupId);
	
}
