package com.kryptonite.rest.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kryptonite.constants.NotificationType;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class NotificationModel {

	private String id;
	private String userId;
	private Boolean acked;
	private NotificationType type;
	private String typeId;
	private Notifiable notifiableModel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getAcked() {
		return acked;
	}
	public void setAcked(Boolean acked) {
		this.acked = acked;
	}
	public NotificationType getType() {
		return type;
	}
	public void setType(NotificationType type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Notifiable getNotifiableModel() {
		return notifiableModel;
	}
	public void setNotifiableModel(Notifiable notifiableModel) {
		this.notifiableModel = notifiableModel;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
}
