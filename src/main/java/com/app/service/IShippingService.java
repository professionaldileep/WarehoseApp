package com.app.service;

import java.util.List;

import com.app.model.Shipping;

public interface IShippingService {
	Integer save(Shipping s);
	void update(Shipping s);
	void delete(Integer id);
	
	Shipping getOne(Integer id);
	List<Shipping> getAllShippings();
	List<Object[]> viewShippings();

}
