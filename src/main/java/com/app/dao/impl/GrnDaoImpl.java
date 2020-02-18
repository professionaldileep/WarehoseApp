package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IGrnDao;
import com.app.model.Grn;
@Repository
public class GrnDaoImpl implements IGrnDao{
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveGrn(Grn grn) {
		return (Integer) ht.save(grn);
	}
	
	@Override
	public void updateGrn(Grn grn) {
		ht.update(grn);
	}
	
	@Override
	public void deleteGrn(Integer id) {
		ht.delete(new Grn(id));
	}
	
	@Override
	public Grn getOneGrn(Integer id) {
		return ht.get(Grn.class, id);
	}
	
	@Override
	public List<Grn> getAllGrns() {
		return ht.loadAll(Grn.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> viewGrns() {
		
		/* String hql=" select id,orderCode from com.app.model.Grn "; */
		DetachedCriteria d=DetachedCriteria.forClass(Grn.class).setProjection(
				Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("orderCode")));
		return (List<Object[]>) ht.findByCriteria(d);
	}
}
