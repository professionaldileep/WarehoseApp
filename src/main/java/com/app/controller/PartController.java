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

import com.app.model.Part;
import com.app.service.IOrderMethodService;
import com.app.service.IPartService;
import com.app.service.IUomService;
import com.app.util.CommonUtil;
import com.app.view.PartExcelView;
import com.app.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {
	
	@Autowired
	private IPartService service;
	
	@Autowired
	private IUomService uomService;
	
	@Autowired
	private IOrderMethodService omService;
	
	
	private void componentsToUi(ModelMap map) {
		List<Object[]> uomlist=uomService.getUomIdAndModel();
		Map<Integer, String> uoms=CommonUtil.convertData(uomlist);
		List<Object[]> saleList=omService.getIdAndOrderCode("sale");
		Map<Integer, String> saleMap=CommonUtil.convertData(saleList);
		List<Object[]> purchaseList=omService.getIdAndOrderCode("purchase");
		Map<Integer, String> purchaseMap=CommonUtil.convertData(purchaseList);
		map.addAttribute("uom", uoms);
		map.addAttribute("saleMap", saleMap);
		map.addAttribute("purchaseMap", purchaseMap);
		map.addAttribute("part", new Part());
	}
	
	@RequestMapping("/reg")
	public String register(ModelMap map) {
		componentsToUi(map);
		return "PartRegister";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePart(@ModelAttribute Part part, ModelMap map) {
		Integer id=service.save(part);
		String msg="Part saved successfully with ID '"+id;
		componentsToUi(map);
		map.addAttribute("msg", msg);
		return "PartRegister";
	}
	
	@RequestMapping("/all")
	public String getOne(ModelMap map) {
		List<Object[]> list=service.viewParts();
		map.addAttribute("list", list);
		return "PartData";
	}
	
	@RequestMapping("/delete")
	public String deletePart(@RequestParam Integer id, ModelMap map) {
		service.delete(id);
		List<Object[]> list=service.viewParts();
		String msg="Part with '"+id+"' deleted successfully";
		map.addAttribute("list", list);
		map.addAttribute("msg", msg);
		return "PartData";
	}
	
	@RequestMapping("/edit")
	public String editPart(@RequestParam Integer id, ModelMap map) {
		componentsToUi(map);
		Part p=service.getOnePart(id);
		map.addAttribute("part", p);
		return "PartEdit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePart(@ModelAttribute Part part, ModelMap map) {
		service.update(part);
		String msg="Part with ID '"+part.getId()+"' Updated Successfully";
		List<Object[]> list= service.viewParts();
		map.addAttribute("msg",msg);
		map.addAttribute("list", list);
		return "PartData";
	}
	
	@RequestMapping("/view")
	public String viewPart(@RequestParam Integer id, ModelMap map) {
		Part p=service.getOnePart(id);
		map.addAttribute("part", p);
		return "PartView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView excelExport(@RequestParam(required = false)Integer id) {
		List<Part> partList= null;
		if(id==null) {
			partList=service.getAllParts();
		}else {
			partList=Arrays.asList(service.getOnePart(id));
		}
		ModelAndView m=new ModelAndView();
		m.setView(new PartExcelView());
		m.addObject("list", partList);
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(required = false)Integer id) {
		List<Part> partList=null;
		if(id==null)
			partList=service.getAllParts();
		else
			partList=Arrays.asList(service.getOnePart(id));
		ModelAndView m= new ModelAndView();
		m.setView(new PartPdfView());
		m.addObject("list", partList);
		return m;
	}
	
}
