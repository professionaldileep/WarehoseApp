package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Shipping;
import com.app.service.IShippingService;
import com.app.view.ShippingExcelView;
import com.app.view.ShippingPdfView;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
	@Autowired
	private IShippingService service;
	
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("shipping",new Shipping());
		return "ShippingRegister";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Shipping shipping,ModelMap map) {
		Integer id=service.save(shipping);
		String msg="Shipping '"+id+"' saved successfully";
		map.addAttribute("msg", msg);
		map.addAttribute("shipping", new Shipping());
		return "ShippingRegister";
	}
	
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<Object[]> list=service.viewShippings();
		map.addAttribute("list", list);
		return "ShippingData";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id, ModelMap map) {
		service.delete(id);
		String msg=" Deleted '"+id+"'Successfully";
		map.addAttribute("msg",msg);
		List<Object[]> list=service.viewShippings();
		map.addAttribute("list", list);
		return "ShippingData";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam Integer id, ModelMap map) {
		Shipping shipping=service.getOne(id);
		map.addAttribute("shipping",shipping);
		return "ShippingEdit";
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute Shipping shipping, ModelMap map) {
		service.update(shipping);
		String msg="Shiping '"+shipping.getId()+"' Updated Successfully";
		map.addAttribute("msg", msg);
		List<Object[]> list=service.viewShippings();
		map.addAttribute("list", list);
		return "ShippingData";
	}
	@RequestMapping("/view")
	public String view(@RequestParam Integer id, ModelMap map) {
		Shipping shipping=service.getOne(id);
		map.addAttribute("shipping", shipping);
		return "ShippingView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView excelExport(@RequestParam(required = false)Integer id) {
		List<Shipping> list=null;
		if(id==null)
			list=service.getAllShippings();
		else
			list=Arrays.asList(service.getOne(id));
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingExcelView());
		m.addObject("list",list);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(required = false)Integer id) {
		List<Shipping> list=null;
		if(id==null)
			list=service.getAllShippings();
		else
			Arrays.asList(service.getOne(id));
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingPdfView());
		m.addObject("list",list);
		return m;
	}
}
