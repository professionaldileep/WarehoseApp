package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;
import com.app.model.PurchaseDtl;

@Repository
public class PurchaseDaoImpl implements IPurchaseDao{

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer savePurchase(Purchase p) {
		return (Integer) ht.save(p);
	}

	@Override
	public void updatePurchase(Purchase p) {
		ht.update(p);
	}

	@Override
	public void deletePurchase(Integer id) {
		ht.delete(new Purchase(id));
	}

	@Override
	public Purchase getOnePurchse(Integer id) {
		return ht.get(Purchase.class, id);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return ht.loadAll(Purchase.class);
	}

	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Object[]> viewPurchases() {
		/* String hql="select id, qualityCheck from com.app.model.Purchase"; */
		DetachedCriteria d=DetachedCriteria.forClass(Purchase.class).setProjection(
				Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("qualityCheck")));
		return (List<Object[]>)ht.findByCriteria(d);
	}

	@Override
	public Integer savePurchaseDtls(PurchaseDtl pdtl) {
		return (Integer)ht.save(pdtl);
	}
	
	@Override
	public void deletePurchaseDtls(Integer id) {
		ht.delete(new PurchaseDtl(id));
	}
	
	@Override
	public List<Object[]> getIdAndCode() {
		DetachedCriteria d= DetachedCriteria.forClass(Purchase.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("orderCode")));
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(d);
		return list;
	}
	
}