package com.kryptonite.email;

public class ConsumerConstants {
	public static class Rabbitmq{
		/*AWS
		public static final String RABBIT_AMQP_HOST = "54.193.46.145";
		public static final String RABBIT_AMQP_HOST_USERNAME = "guest";
		public static final String RABBIT_AMQP_HOST_PASSWORD = "guest";
		*/
		/*Local */
		public static final String RABBIT_AMQP_HOST = "localhost";
		public static final String RABBIT_AMQP_HOST_USERNAME = "root";
		public static final String RABBIT_AMQP_HOST_PASSWORD = "admin";
		public static final String RABBIT_AMQP_VIRTUAL_HOST = "virtualHost";
		public static final int    RABBIT_AMQP_HEARTBEAT = 0;
		public static final String RABBIT_AMQP_QUEUE_NAME = "nutped";
		public static final String RABBIT_AMQP_XCHANGE_NAME = "nutped";
		public static final String RABBIT_AMQP_ROUTING_KEY= "nutped";
		public static final int    RABBIT_AMQP_EVENT_PREFETCH_COUNT = 1;
		public static final String MSG_TOKEN_SEPARATOR = "-";
		public static final int MSG_TOTAL_TOKEN = 3;
	}
}
