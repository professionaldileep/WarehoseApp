package com.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Grn;
import com.app.model.GrnDtl;
import com.app.model.PurchaseDtl;
import com.app.service.IPurchaseService;

@Component
public class GrnUtil {

	@Autowired
	private IPurchaseService purchaseService;
	
	public void mapGrnChilds(Grn grn) {
		Integer id= grn.getPurchase().getId();
		List<PurchaseDtl> pdtls = purchaseService.getOnePurchse(id).getPurchaseDtl();
	
		List<GrnDtl> grnDtls = new ArrayList<GrnDtl>();
		
		for(PurchaseDtl pdtl:pdtls) {
			GrnDtl gdtl=new GrnDtl(pdtl.getPart().getCode(), pdtl.getPart().getBaseCost(), pdtl.getQnt(), pdtl.getPart().getBaseCost()*pdtl.getQnt());
			grnDtls.add(gdtl);
		}
		grn.setChilds(grnDtls);
	}
}
