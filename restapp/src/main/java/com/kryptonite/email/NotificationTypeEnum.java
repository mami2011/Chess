package com.kryptonite.email;

public enum NotificationTypeEnum {
	REGISTRATION  (1, "registration"),
	CHANGEPASSWORD   (2, "changePassword"),
	CHANGEPROFILE   (3, "changeProfile"),
	COMMENT   (4, "comment"),
	FOLLOW   (5, "follow"),
	LIKE (6, "like"),
	NEWPASSWORD (7, "newPassword"),;
	
	private int id;
	private String notificationType;
	
	NotificationTypeEnum(int id, String value) {
		this.id = id;
		this.notificationType = value;
	}

	public int getId() {
		return id;
	}

	public String getNotificationType() {
		return notificationType;
	}
	
	public static NotificationTypeEnum get(int id) {
		NotificationTypeEnum[] values = NotificationTypeEnum.values();
		for(NotificationTypeEnum e : values) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	public static NotificationTypeEnum get(String value) {
		if((value == null) || (value.trim().isEmpty())) {
			return null;
		}
		NotificationTypeEnum[] values = NotificationTypeEnum.values();
		for(NotificationTypeEnum e : values) {
			if(e.getNotificationType().equalsIgnoreCase(value)) {
				return e;
			}
		}
		return null;
	}
}