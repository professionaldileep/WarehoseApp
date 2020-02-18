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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/om")
public class OrderMethodController {
	
	@Autowired
	private IOrderMethodService service;
	
	
	@RequestMapping("/reg")
	public String show(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		Integer id=service.saveOrderMethod(orderMethod);
		map.addAttribute("orderMethod", new OrderMethod());
		String msg="Order Method '"+id+"' saved successfully";
		map.addAttribute("msg", msg);
		return "OrderMethodRegister";
	}
	
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		List<Object[]> list=service.viewOrderMethods();
		map.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer id, ModelMap map) {
		service.deleteOrderMethod(id);
		String msg="OrderMethod '"+id+"' Deleted Successfully";
		map.addAttribute("msg", msg);
		List<Object[]> list=service.viewOrderMethods();
		map.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	@RequestMapping("/edit")
	public String editOrderMethod(@RequestParam Integer id, ModelMap map) {
		OrderMethod om=service.getOneOrderMethod(id);
		map.addAttribute("orderMethod", om);
		return "OrderMethodEdit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		service.updateOrderMethod(orderMethod);
		String msg="OrderMethod '"+orderMethod.getId()+"' Updated Successfully";
		List<Object[]> list=service.viewOrderMethods();
		map.addAttribute("list", list);
		map.addAttribute("msg",msg);
		return "OrderMethodData";
	}
	
	@RequestMapping("/view")
	public String viewOrderMethod(@RequestParam Integer id, ModelMap map) {
		OrderMethod om=service.getOneOrderMethod(id);
		map.addAttribute("orderMethod", om);
		return "OrderMethodView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required = false)Integer id) {
		List<OrderMethod> list=null;
		if(id==null)
			list=service.getAllOrderMethods();
		else
			list=Arrays.asList(service.getOneOrderMethod(id));
		ModelAndView m= new ModelAndView();
		m.setView(new OrderMethodExcelView());
		m.addObject("list", list);
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView exportPdf(@RequestParam(required = false)Integer id) {
		List<OrderMethod> list=null;
		if(id==null)
			list=service.getAllOrderMethods();
		else
			list=Arrays.asList(service.getOneOrderMethod(id));
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdfView());
		m.addObject("list", list);
		return m;
	}
}
