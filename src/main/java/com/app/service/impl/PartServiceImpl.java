package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPartDao;
import com.app.model.Part;
import com.app.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private IPartDao dao;
	
	@Override
	@Transactional
	public Integer save(Part p) {
		return dao.save(p);
	}

	@Override
	@Transactional
	public void update(Part p) {
		dao.update(p);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Part getOnePart(Integer id) {
		return dao.getOnePart(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Part> getAllParts() {
		return dao.getAllParts();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> viewParts() {
		return dao.viewParts();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getPartIdAndCode() {
		return dao.getPartIdAndCode();
	}

}
