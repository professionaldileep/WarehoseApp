package com.app.dao;

import java.util.List;

import com.app.model.Sale;

public interface ISaleDao {
	public Integer saveSale(Sale s);
	public void update(Sale s);
	public void delete(Integer id);
	public Sale getOneSale(Integer id);
	public List<Sale> getAllSales();
	public List<Object[]> viewSales();
}
