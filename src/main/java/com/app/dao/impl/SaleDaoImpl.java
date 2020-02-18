package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleDao;
import com.app.model.Sale;

@Repository
public class SaleDaoImpl implements ISaleDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveSale(Sale s) {
		return (Integer)ht.save(s);
	}
	
	@Override
	public void update(Sale s) {
		ht.update(s);
	}
	
	@Override
	public void delete(Integer id) {
		ht.delete(new Sale(id));
	}
	
	@Override
	public Sale getOneSale(Integer id) {
		return ht.get(Sale.class, id);
	}
	
	@Override
	public List<Sale> getAllSales() {
		return ht.loadAll(Sale.class);
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Object[]> viewSales() {
		/* String hql=" select id, orderCode, stockMode from com.app.model.Sale "; */
		DetachedCriteria d=DetachedCriteria.forClass(Sale.class)
				.setProjection(Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("orderCode"))
				.add(Projections.property("stockMode")));
		return (List<Object[]>) ht.findByCriteria(d);
	}
}
