package com.nc.service;

import java.util.List;

import com.nc.pojo.Product;
import com.nc.pojo.PropertyValue;

public interface PropertyValueService {
	void init(Product p);
	void update(PropertyValue pv);
	
	PropertyValue get(int ptid, int pid);
	List<PropertyValue> list(int pid);
}
