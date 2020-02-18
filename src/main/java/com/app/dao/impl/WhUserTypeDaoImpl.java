package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUser(WhUserType wh) {
		return (Integer) ht.save(wh);
	}
	@Override
	public void updateWhUser(WhUserType wh) {
		ht.update(wh);
	}
	@Override
	public void deleteWhUser(Integer id) {
		WhUserType wh=new WhUserType(id);
		ht.delete(wh);
	}
	@Override
	public WhUserType getOneWhUser(Integer id) {
		return ht.get(WhUserType.class, id);
	}
	@Override
	public List<WhUserType> getAllWhUsers()
	{
		return ht.loadAll(WhUserType.class);
	}
	@Override
	public List<Object[]> viewWhUsers() {
		/* String hql="select id,userType,userEmail from com.app.model.WhUserType"; */
		DetachedCriteria d=DetachedCriteria.forClass(WhUserType.class)
		.setProjection(Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("userType"))
				.add(Projections.property("userEmail")));
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.findByCriteria(d);
		return list;
	}
	
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Object[]> getIdAndCodeByType(String s) {
		/*
		 * String
		 * hql=" select id, userCode from com.app.model.WhUserType where userType= ?0 ";
		 */
		DetachedCriteria d=DetachedCriteria.forClass(WhUserType.class).setProjection(
				Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("userCode")))
				.add(Restrictions.eq("userType", s));
		return (List<Object[]>)ht.findByCriteria(d);
	}
}
