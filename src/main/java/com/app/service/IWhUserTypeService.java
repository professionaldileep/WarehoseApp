package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {
	
	public Integer saveWhUser(WhUserType wh);
	public void updateWhUser(WhUserType wh);
	public void deleteWhUser(Integer id);
	public WhUserType getOneWhUser(Integer id);
	public List<Object[]> viewWhUsers();
	public List<WhUserType> getAllWhUsers();
	List<Object[]> getIdAndCodeByType(String s);
}
