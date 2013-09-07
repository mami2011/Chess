package com.vendertool.mercadolibreadapter.orders;

import java.util.Date;

public class Order {

	private Integer id;
	private Status status;
	private String status_detail;
	private Date date_created;
	private Date date_closed;
	private Integer order_items;
	private Double total_amount;

}