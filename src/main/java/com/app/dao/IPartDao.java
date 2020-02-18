package com.app.dao;

import java.util.List;

import com.app.model.Part;

public interface IPartDao {

	Integer save(Part p);
	void update(Part p);
	void delete(Integer id);

	Part getOnePart(Integer id);
	List<Part> getAllParts();
	List<Object[]> viewParts();
	List<Object[]> getPartIdAndCode();
}
