package com.kryptonite.email;
import java.io.IOException;
import java.util.List;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
public class EmailConsumer {

	private Connection connection = null;
	private Channel channel = null;

	private QueueingConsumer consumer;

	private String routingKey = null; 
	private String exchangeName = null;
	private String queueName = null;
	private List<String> exchanges;			// to create multiple exchanges once other consumers are needed	
	private boolean durableQueue = false;
	private boolean durableExchange = false;
	private int totalMsgsToPrefetch = 10;
	private boolean autoAck = false;
	private String consumerTag = "nutped";
	private int channelNumber = 1234;
	private ApplicationMailer mailer;


    
	public EmailConsumer init() throws Exception {		 
		
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("sendMail.xml");

		//Get the mailer instance
		mailer = (ApplicationMailer) context.getBean("mailService");


		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ConsumerConstants.Rabbitmq.RABBIT_AMQP_HOST);

		connection = factory.newConnection();		 
		try {
			// Create a channel
			channel = connection.createChannel(channelNumber);
			// if channel created successfully
			if(channel!=null){
		
				channel.queueDeclare(queueName, durableQueue, false, false, null);

				channel.queueBind(queueName, exchangeName, "");

				channel.basicQos(totalMsgsToPrefetch);

				// create a queueing consumer
				consumer = new QueueingConsumer(channel);

				// Create a consumer and manually ack message after processing
				String crConsumerTag = channel.basicConsume(queueName, autoAck,consumerTag, consumer);
				// cancel consumer if consumer cannot be created
				if(!crConsumerTag.equalsIgnoreCase(consumerTag)) {
					channel.basicCancel(crConsumerTag);
				}
			}
		} catch(IOException ex) {
			if(channel!=null) {
				// unbind the queue, delete exchange and queue
				try {
					channel.queueUnbind(queueName, exchangeName, routingKey);
					channel.queueDelete(queueName);
					channel.exchangeDelete(exchangeName);
					channel.close();
				}
				catch(IOException e){}
			}
		}
		return this;
	}

	public void setChannelNumber(int channelNumber) {
		this.channelNumber = channelNumber;
	}
	public void setConsumerTag(String consumerTag) {
		this.consumerTag = consumerTag;
	}

	public void setAutoAck(boolean autoAck) {
		this.autoAck = autoAck;
	}

	public void setDurableQueue(boolean durable) {
		this.durableQueue = durable;
	}

	public void setDurableExchange(boolean durable) {
		this.durableExchange = durable;
	}

	public void setPrefetchMsgCount(int totalMsgsToPrefetch) {
		this.totalMsgsToPrefetch = totalMsgsToPrefetch;
	}

	public boolean isChannelActive() {
		return channel != null && channel.isOpen() ; 
	}

	public void setExchangeName(String exchangeName){
		this.exchangeName = exchangeName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey ;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				
			}
			catch (IOException ignore) {}
		}
	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
	}

	public void destroy() {
		if(channel != null) {
			try {
				channel.close(); 
			} catch(Exception e) {}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch(Exception e) {
			}
		}
	}

	public void processEvents()  {
		while (true) {
			try {
				// Get the next message in the queue
				Delivery delivery = consumer.nextDelivery();
				if (delivery == null)
				{
					if (channel.isOpen() == false) { 
						throw new ShutdownSignalException(false, false, delivery, delivery); }
				}
				else
				{

					String message = new String(delivery.getBody());  
					if(message != null & (((message = message.trim()).length())>0)) {

						if (message.contains(ConsumerConstants.Rabbitmq.MSG_TOKEN_SEPARATOR)) {
							String[] tokens = message.split(ConsumerConstants.Rabbitmq.MSG_TOKEN_SEPARATOR);

							if (tokens.length != ConsumerConstants.Rabbitmq.MSG_TOTAL_TOKEN) {
								channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);  // ignore the message by ACK so that it will not clog in the Q
							}
							else { 
								mailer.sendMail(tokens[0],tokens[3]);
								channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);   // ack one message

							}
						}
						else {
							// ignore the message
							System.out.println( "EmailConsumer::Message: Junk message");
							channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
						}
					}	
				}}
			catch (ShutdownSignalException e) {
				System.out.println( "Consumer:: " + EmailConsumer.class.getName() + " Shutodwon signal received.");
				break;
			} 
			catch (ConsumerCancelledException e) {
				System.out.println( "Consumer:: " + EmailConsumer.class.getName() + " Consumer cancelled exception: " + e.getMessage()); 
				break;
			} 
			catch (InterruptedException e) {
				System.out.println( "Consumer:: " + EmailConsumer.class.getName() + " Interruption exception: " + e.getMessage()); 
				continue;
			} 
			catch (IOException e) {
				System.out.println( "Consumer:: " + EmailConsumer.class.getName() + " Could not ack message: " + e.getMessage()); 
				break;
			}
			catch (Exception e){
				System.out.println( "Consumer:: " + EmailConsumer.class.getName() + " Could not ack message: " + e.getMessage()); 
				break;
			}
		}
	}


	public static void main(String[] args) {
		EmailConsumer consumer = null;
		try {
			consumer = new EmailConsumer();
			// consumer.setChannelNumber(ConsumerConstants.Rabbitmq.RABBIT_AMQP_CHANNEL_NUMBER);
			consumer.setExchangeName(ConsumerConstants.Rabbitmq.RABBIT_AMQP_XCHANGE_NAME);
			consumer.setQueueName(ConsumerConstants.Rabbitmq.RABBIT_AMQP_QUEUE_NAME);
			consumer.setDurableExchange(true);
			consumer.setDurableQueue(true);
			// consumer.setRoutingKey(ConsumerConstants.Rabbitmq.RABBIT_AMQP_ROUTING_KEY);
			// consumer.setConsumerTag(ConsumerConstants.Rabbitmq.RABBIT_AMQP_CONSUMER_TAG);
			consumer.setPrefetchMsgCount(ConsumerConstants.Rabbitmq.RABBIT_AMQP_EVENT_PREFETCH_COUNT);
			consumer.setAutoAck(false);
			consumer.init();
			if(consumer.isChannelActive()) {
				consumer.processEvents();
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(consumer != null) {
				consumer.closeConnection();
			}
		}
	}

}
