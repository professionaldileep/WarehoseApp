package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao{

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer) ht.save(st);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		ht.update(st);
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ShipmentType s=new ShipmentType();
		s.setId(id);
		ht.delete(s);
	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}
	
	@Override
	@SuppressWarnings({"unchecked" })
	public List<Object[]> getShipmentIdAndCode() {
		/*
		 * String
		 * hql=" select id, shipmentCode from com.app.model.ShipmentType where enable='YES' "
		 * ;
		 */
		DetachedCriteria d=DetachedCriteria.forClass(ShipmentType.class).add(Restrictions.eq("enable", "YES"))
				.setProjection(Projections.projectionList().add(Projections.property("id"))
						.add(Projections.property("shipmentCode")));
		return (List<Object[]>)ht.findByCriteria(d);
	}
}
