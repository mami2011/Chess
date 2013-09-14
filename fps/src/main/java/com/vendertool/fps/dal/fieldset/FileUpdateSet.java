package com.vendertool.fps.dal.fieldset;

import com.mysema.query.types.Path;
import com.vendertool.fps.dal.dao.codegen.QFile;

public class FileUpdateSet {
	private static final QFile FILE = QFile.file;
	
	private static class FileUpdateSetHolder {
		private static final FileUpdateSet INSTANCE = new FileUpdateSet();
	}
	
	public static FileUpdateSet getInstance() {
		return FileUpdateSetHolder.INSTANCE;
	}
	
	public final Path<?>[] STATUS = {
		FILE.status,
		FILE.lastModifiedDate
	};
}
