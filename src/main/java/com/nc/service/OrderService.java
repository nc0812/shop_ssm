package com.nc.service;

import java.util.List;

import com.nc.pojo.Order;
import com.nc.pojo.OrderItem;

public interface OrderService {
	String waitPay = "waitPay";
	String waitDelivery = "waitDelivery";
	String waitConfirm = "waitConfirm";
	String waitReview = "waitReview";
	String finish = "finish";
	String delete = "delete";
	
	void add(Order c);
	void delete(int id);
	void update(Order c);
	Order get(int id);
	List list();
	
	float add(Order c, List<OrderItem> ois);

	List list(int uid, String excludedStatus);
}
