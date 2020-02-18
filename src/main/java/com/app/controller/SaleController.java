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

import com.app.model.Sale;
import com.app.model.SaleDtl;
import com.app.service.ISaleService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.CommonUtil;
import com.app.view.SaleExcelView;
import com.app.view.SalePdfView;

@Controller
@RequestMapping("/sale")
public class SaleController {
	@Autowired
	private ISaleService service;
	
	@Autowired
	private IShipmentTypeService shiptypeService;

	@Autowired
	private IWhUserTypeService whuserService;
	
	private void componentsToUi(ModelMap map){
		List<Object[]> list=shiptypeService.getShipmentIdAndCode();
		Map<Integer, String> shipMap=CommonUtil.convertData(list);
		List<Object[]> whuserList= whuserService.getIdAndCodeByType("CUSTOMER");
		Map<Integer, String> whuserMap=CommonUtil.convertData(whuserList);
		map.addAttribute("shipmentTypeCode",shipMap);
		map.addAttribute("customer",whuserMap);
		map.addAttribute("sale",new Sale("Sale Only"));
	}
	
	//	1.Open Register Page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		componentsToUi(map);
		return "SaleRegister";
	}
	
//	2. save data to DB
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSale(@ModelAttribute Sale sale,ModelMap map) {
		Integer id=service.saveSale(sale);
		componentsToUi(map);
		String msg="Sale '"+id+"' saved Successfully";
		map.addAttribute("msg",msg);
		return "SaleRegister";
	}
//	3. View Rows in Data page
	@RequestMapping("/all")
	public String viewSale(ModelMap map) {
		List<Object[]> list=service.viewSales();
		map.addAttribute("list",list);
		return "SaleData";
	}
//	4.Delete Rows in Data Page
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map) {
		service.delete(id);
		List<Object[]> list=service.viewSales();
		String msg="Sale '"+id+"' Deleted Successfully";
		map.addAttribute("msg",msg);
		map.addAttribute("list",list);
		return "SaleData";
	}
	
//	5.Edit rows 
	@RequestMapping("edit")
	public String edit(@RequestParam Integer id, ModelMap map) {
		Sale sale=service.getOneSale(id);
		componentsToUi(map);
		map.addAttribute("sale",sale);
		return "SaleEdit";
	}
	
//	6. Update Sale Data
	@RequestMapping("/update")
	public String update(@ModelAttribute Sale sale,ModelMap map) {
		service.update(sale);
		String msg="Sale With Id: '"+sale.getId()+"' Updated Successfully ";
		List<Object[]> list= service.viewSales();
		map.addAttribute("msg", msg);
		map.addAttribute("list", list);
		return "SaleData";
	}
	
//	7. View One Sale
	@RequestMapping("/view")
	public String view(@RequestParam Integer id,ModelMap map) {
		Sale s=service.getOneSale(id);
		map.addAttribute("sale",s);
		return "SaleView";
	}
//	8.Excel
	@RequestMapping("/excel")
	public ModelAndView excel(@RequestParam(required = false)Integer id) {
		List<Sale> list=null;
		if(id==null)
			list=service.getAllSales();
		else
			list=Arrays.asList(service.getOneSale(id));
		ModelAndView m=new ModelAndView();
		m.setView(new SaleExcelView());
		m.addObject("list", list);
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView pdf(@RequestParam(required = false)Integer id) {
		List<Sale> list= null;
		if(id==null)
			list=service.getAllSales();
		else
			list=Arrays.asList(service.getOneSale(id));
		ModelAndView m=new ModelAndView();
		m.setView(new SalePdfView());
		m.addObject("list", list);
		return m;
	}
	
	@RequestMapping("/parts")
	public String showSale(@RequestParam Integer id, ModelMap map) {
		map.addAttribute("saleDtl",new SaleDtl());
		return "SaleParts";
	}
	
}
