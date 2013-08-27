package com.vendertool.consumer;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class App 
{
	private final static String QUEUE_NAME = "fileQ";
	private final static String AMQP_BROKER_NAME = "AWS_SERVER_NAME";
	private static final Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args ) throws Exception
    {
        logger.log(Level.INFO, "Consumer:: " + App.class.getName() + " started.");
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(AMQP_BROKER_NAME);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
        
        while (true) {
          QueueingConsumer.Delivery delivery = consumer.nextDelivery();
          String message = new String(delivery.getBody());
          System.out.println(" [x] Received '" + message + "'");
        }
    }
}
