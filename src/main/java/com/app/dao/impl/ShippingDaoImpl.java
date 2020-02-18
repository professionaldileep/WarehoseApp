package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShippingDao;
import com.app.model.Shipping;

@Repository
public class ShippingDaoImpl implements IShippingDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer save(Shipping s) {
		return (Integer) ht.save(s);
	}

	@Override
	public void update(Shipping s) {
		ht.update(s);
	}

	@Override
	public void delete(Integer id) {
		Shipping s= new Shipping(id);
		ht.delete(s);
	}

	@Override
	public Shipping getOne(Integer id) {
		return ht.get(Shipping.class, id);
	}

	@Override
	public List<Shipping> getAllShippings() {
		return ht.loadAll(Shipping.class);
	}

	@SuppressWarnings({"unchecked" })
	@Override
	public List<Object[]> viewShippings() {
		/*
		 * String
		 * hql=" select id, shippingRefNum, shipToAddr from com.app.model.Shipping ";
		 */
		DetachedCriteria d= DetachedCriteria.forClass(Shipping.class).setProjection(
				Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("shippingRefNum"))
				.add(Projections.property("shipToAddr")));
		return (List<Object[]>) ht.findByCriteria(d);
	}
	

}
