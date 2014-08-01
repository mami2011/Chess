package com.kryptonite.rest.resource;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import com.kryptonite.constants.NPLabels;
import com.kryptonite.constants.NotificationType;
import com.kryptonite.utils.DAO;

@Singleton
class Utils {

	@Inject
	GraphDatabaseService db;
	
	@Inject
	DAO dao;
	
	void addNotification(NotificationType type, String typeId, String userId) {
		
		Node notificationNode = db.createNode();
		String notId = "not" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
		notificationNode.setProperty("id", notId);
		notificationNode.setProperty("type", type.name());
		notificationNode.setProperty("typeid",typeId);
		notificationNode.setProperty("userid",userId);
		notificationNode.setProperty("acked",false);
		dao.addLabel(notId, NPLabels.NOTIFICATION.name());
	}
}
