package com.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;
import com.app.service.IPartService;
import com.app.service.IPurchaseService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.CommonUtil;
import com.app.util.PurchaseUtil;
import com.app.view.PurchaseExcelView;
import com.app.view.PurchasePdfView;
import com.app.view.VendorInvoicePdf;

@RequestMapping("/purchase")
@Controller
public class PurchaseController {
	
	@Autowired
	private IPurchaseService service;
	
	@Autowired
	private IShipmentTypeService shiptypeService;
	
	@Autowired
	private IWhUserTypeService whuserService;
	
	@Autowired
	private IPartService partService;
	
	@Autowired
	private PurchaseUtil util;
	private void addUiComponents(ModelMap map){
		List<Object[]> shipList= shiptypeService.getShipmentIdAndCode();
		Map<Integer, String> shipMap= CommonUtil.convertData(shipList);
		map.addAttribute("shipmentCode",shipMap);
		List<Object[]> whuserList= whuserService.getIdAndCodeByType("VENDOR");
		Map<Integer, String> whuserMap = CommonUtil.convertData(whuserList);
		map.addAttribute("whuserCode", whuserMap);
	
	}
	
//	1.To Show Register Page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("purchase", new Purchase("OPEN"));
		addUiComponents(map);
		return "PurchaseRegister";
	}
	
//	2.To save the purchase to DB
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePurchase(@ModelAttribute Purchase purchase, ModelMap map) {
		Integer id=service.savePurchase(purchase);
		map.addAttribute("purchase", new Purchase("OPEN"));
		addUiComponents(map);
		String msg="Purchase'"+id+"'saved";
		map.addAttribute("msg", msg);
		return "PurchaseRegister";
	}
	
//	3. To Get all purchases 
	@RequestMapping("/all")
	public String getAllPurchases(ModelMap map) {
		List<Object[]> list=service.viewPurchases();
		map.addAttribute("list", list);
		return "PurchaseData";
	}
//	4. TO Delete One purchase
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id, ModelMap map) {
		service.deletePurchase(id);
		String msg="Purchase '"+id+"' Deleted";
		List<Object[]> list=service.viewPurchases();
		map.addAttribute("msg",msg);
		map.addAttribute("list",list);
		return "PurchaseData";
	}
	
//	5. TO show Edit page
	@RequestMapping("/edit")
	public String edit(@RequestParam Integer id,ModelMap map) {
		Purchase p=service.getOnePurchse(id);
		addUiComponents(map);
		map.addAttribute("purchase",p);
		return "PurchaseEdit";
	}
//	6. Update Purchase
	@RequestMapping("/update")
	public String update(@ModelAttribute Purchase purchase, ModelMap map) {
		service.updatePurchase(purchase);
		List<Object[]> list=service.viewPurchases();
		String msg="Purchase '"+purchase.getId()+"' Updated Successfully";
		map.addAttribute("msg",msg);
		map.addAttribute("list", list);
		return "PurchaseData";
	}
//	7. View One Purchase
	@RequestMapping("/view")
	public String view(@RequestParam Integer id, ModelMap map) {
		Purchase p=service.getOnePurchse(id);
		map.addAttribute("purchase", p);
		return "PurchaseView";
	}
//	8. Excel Export 
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required = false)Integer id) {
		List<Purchase> purchase=null;
		if(id==null) {
			purchase=service.getAllPurchases();
		}else {
			purchase=Arrays.asList(service.getOnePurchse(id));
		}
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseExcelView());
		m.addObject("purchase", purchase);
		return m;
	}
	
//	9. Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView exportPdf(@RequestParam(required = false)Integer id) {
		List<Purchase> purchase=null;
		if(id==null)
			purchase=service.getAllPurchases();
		else
			purchase=Arrays.asList(service.getOnePurchse(id));
		ModelAndView m= new ModelAndView();
		m.setView(new PurchasePdfView());
		m.addObject("purchase", purchase);
		return m;
	}
	
	
	/* 
	 * Screen 2 
	 * */
	
	@RequestMapping("/parts")
	public String showParts(@RequestParam Integer id, ModelMap map) {
		/* form backing obj & link child with parent(Pk-Fk-Id) */
		map.addAttribute("purchaseDtl", new PurchaseDtl(new Purchase(id)));
		List<Object[]> parts= partService.getPartIdAndCode();
		Map<Integer, String> partMap=CommonUtil.convertData(parts);
		Purchase po=service.getOnePurchse(id);
		util.allocateSlno(po);
		map.addAttribute("parent", po);
		map.addAttribute("parts", partMap);
		return "PurchaseParts";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveParts(@ModelAttribute PurchaseDtl pdtl) {
		service.savePurchaseDtls(pdtl);
		return "redirect:parts?id="+pdtl.getParent().getId();
	}
	
	@RequestMapping("/remove")
	public String deleteParts(@RequestParam Integer id, @RequestParam Integer dtlId) {
		service.deletePurchaseDtls(dtlId);
		return "redirect:parts?id="+id;
	}
	
	@RequestMapping("/vendorinvoice")
	public ModelAndView generateVendorInvoice(@RequestParam Integer id){
		ModelAndView m=new ModelAndView();
		  m.setView(new VendorInvoicePdf());
		  //send data (Purchase with Dtls)
		  Purchase po=service.getOnePurchse(id);
		  m.addObject("parent",po);
		  return m;
	}
	
}
