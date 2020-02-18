package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShippingDao;
import com.app.model.Shipping;
import com.app.service.IShippingService;
@Service
public class ShippingServiceImpl implements IShippingService {
	
	@Autowired
	private IShippingDao dao;
	
	@Override
	@Transactional
	public Integer save(Shipping s) {
		return dao.save(s);
	}

	@Override
	@Transactional
	public void update(Shipping s) {
		dao.update(s);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Shipping getOne(Integer id) {
		return dao.getOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Shipping> getAllShippings() {
		return dao.getAllShippings();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> viewShippings() {
		return dao.viewShippings();
	}

}
