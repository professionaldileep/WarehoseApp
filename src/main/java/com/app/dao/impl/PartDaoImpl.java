package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPartDao;
import com.app.model.Part;

@Repository
public class PartDaoImpl implements IPartDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer save(Part p) {
		return (Integer) ht.save(p);
	}

	@Override
	public void update(Part p) {
		ht.update(p);
	}

	@Override
	public void delete(Integer id) {
		ht.delete(new Part(id));
	}

	@Override
	public Part getOnePart(Integer id) {
		return ht.get(Part.class, id);
	}

	@Override
	public List<Part> getAllParts() {
		return ht.loadAll(Part.class);
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Object[]> viewParts() {
		/* String hql=" select id, code, baseCurr from com.app.model.Part "; */
		DetachedCriteria d= DetachedCriteria.forClass(Part.class).setProjection(Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("code"))
				.add(Projections.property("baseCurr")));
		return (List<Object[]>) ht.findByCriteria(d);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getPartIdAndCode() {
		DetachedCriteria dc= DetachedCriteria.forClass(Part.class).setProjection(Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("code")));
		return (List<Object[]>)ht.findByCriteria(dc);
	}
}
