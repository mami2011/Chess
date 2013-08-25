package com.vendertool.common.dal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractTimestampEntity {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	protected Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19)
	protected Date lastModifiedDate;

	@PrePersist
	public void onCreate() {
		lastModifiedDate = createdDate = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		lastModifiedDate = new Date();
	}
}