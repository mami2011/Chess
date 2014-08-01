package com.kryptonite.email;

public enum NotificationModeEnum {
	EMAIL  (1, "email"),
	PUSHNOTIFICATION   (2, "pushNotification"),
	SMS (3, "sms");
	
	private int id;
	private String notificationType;
	
	NotificationModeEnum(int id, String value) {
		this.id = id;
		this.notificationType = value;
	}

	public int getId() {
		return id;
	}

	public String getNotificationType() {
		return notificationType;
	}
	
	public static NotificationModeEnum get(int id) {
		NotificationModeEnum[] values = NotificationModeEnum.values();
		for(NotificationModeEnum e : values) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	public static NotificationModeEnum get(String value) {
		if((value == null) || (value.trim().isEmpty())) {
			return null;
		}
		NotificationModeEnum[] values = NotificationModeEnum.values();
		for(NotificationModeEnum e : values) {
			if(e.getNotificationType().equalsIgnoreCase(value)) {
				return e;
			}
		}
		return null;
	}
}