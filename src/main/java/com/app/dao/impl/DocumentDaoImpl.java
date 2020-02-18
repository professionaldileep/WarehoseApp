package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao{
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveDocument(Document d) {
		return (Integer) ht.save(d);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getDocumentIdAndName() {
		String hql="select fileId,fileName from com.app.model.Document";
		/*
		 * DetachedCriteria
		 * d=DetachedCriteria.forClass(Document.class).setProjection(Projections.
		 * projectionList() .add(Projections.property("fileId"))
		 * .add(Projections.property("fileName")));
		 
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(d);
		*/
		
		return (List<Object[]>)ht.find(hql);
	}
	@Override
	public Document getOneDocument(Integer id) {
		return ht.get(Document.class, id);
	}
}
