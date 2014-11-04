package com.kryptonite.email;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.neo4j.graphdb.Node;

import com.kryptonite.utils.DAO;
import com.rabbitmq.client.*;

@Singleton
public class RabbitMQPublisher {
	@Inject
	private DAO dao;
	
	public  void publishEvent( String userId , NotificationModeEnum notificationMode , NotificationTypeEnum notificationType, final Locale locale) throws Exception {
		
		ConnectionFactory factory = new ConnectionFactory();
		//Rabbitmq connection details 
		factory.setUsername("guest");
		factory.setPassword("guest");
		factory.setVirtualHost("/");
		factory.setHost("ec2-54-193-46-145.us-west-1.compute.amazonaws.com");
		//factory.setPort(15672);
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
		String exchangeName = "nutped";
		//  String routingKey = "testRoute";
				
		int mode = notificationMode.getId();
		int emailType = notificationType.getId();
		String myPayload = userId + "-" + mode + "-" +emailType;
		byte[] messageBodyBytes = (myPayload).getBytes();
			channel.basicPublish(exchangeName,""
					,MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes) ;

		channel.close();
		conn.close();
	}

	
}