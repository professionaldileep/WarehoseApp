package com.app.dao;

import java.util.List;

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;

public interface IPurchaseDao {
	public Integer savePurchase(Purchase p);
	public void updatePurchase(Purchase p);
	public void deletePurchase(Integer id);
	public Purchase getOnePurchse(Integer id);
	public List<Purchase> getAllPurchases();
	public List<Object[]> viewPurchases();
	
	Integer savePurchaseDtls(PurchaseDtl pdtl);
	void deletePurchaseDtls(Integer id);
	List<Object[]> getIdAndCode();
}
