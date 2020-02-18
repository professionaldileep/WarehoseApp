package com.app.service;

import java.util.List;

import com.app.model.Uom;

public interface IUomService {
	
	public Integer saveUom(Uom m);
	public void updateUom(Uom m);
	public void deleteUom(Integer id);
	public Uom getOneUom(Integer id);
	public List<Uom> getAllUoms();
	public List<Object[]> getUomTypeAndCount();
	List<Object[]> getUomIdAndModel();
}
