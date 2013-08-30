package com.vendertool.fps.dal.file;

import java.util.List;

public interface FileDao {

	void insert (File file);

	void update(File file);

	void delete(File file);

	List<File> findByAccountId(long accountId);
	List<File> findByAccountIdAndFileGroupId(long accountId,String fileGroupId);
	List<File> findByAccountIdAndFileId(long accountId,long fileId);
}
