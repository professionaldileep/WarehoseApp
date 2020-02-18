package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUom(Uom m) {
		return (Integer) ht.save(m);
	}

	@Override
	public void updateUom(Uom m) {
		ht.update(m);
	}

	@Override
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}

	@Override
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Object[]> getUomTypeAndCount() {
		/*
		 * String
		 * hql=" select uomType, count(uomType) from com.app.model.Uom group by uomType "
		 * ;
		 */
		DetachedCriteria d=DetachedCriteria.forClass(Uom.class).setProjection(
				Projections.projectionList()
				.add(Projections.groupProperty("uomType"))
				.add(Projections.count("uomType")));
		return (List<Object[]>)ht.findByCriteria(d);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Object[]> getUomIdAndModel() {
		/* String hql=" select id, uomModel from com.app.model.Uom "; */
		DetachedCriteria d=DetachedCriteria.forClass(Uom.class).setProjection(
				Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("uomModel")));
		return (List<Object[]>)ht.findByCriteria(d);
	}

}
