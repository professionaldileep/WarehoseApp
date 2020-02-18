package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService{
	@Autowired
	private IWhUserTypeDao dao;
	
	@Transactional
	@Override
	public Integer saveWhUser(WhUserType wh) {
		return dao.saveWhUser(wh);
	}
	
	@Override
	@Transactional
	public void updateWhUser(WhUserType wh) {
		dao.updateWhUser(wh);
	}
	
	@Override
	@Transactional
	public void deleteWhUser(Integer id) {
		dao.deleteWhUser(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public WhUserType getOneWhUser(Integer id) {
		return dao.getOneWhUser(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<WhUserType> getAllWhUsers() {
		return dao.getAllWhUsers();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> viewWhUsers() {
		return dao.viewWhUsers();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getIdAndCodeByType(String s) {
		return dao.getIdAndCodeByType(s);
	}
}
