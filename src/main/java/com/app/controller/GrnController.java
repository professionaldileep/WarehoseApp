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

import com.app.model.Grn;
import com.app.service.IGrnService;
import com.app.service.IPurchaseService;
import com.app.util.CommonUtil;
import com.app.view.GrnExcelView;
import com.app.view.GrnPdfView;

@Controller
@RequestMapping("/grn")
public class GrnController {
	
	@Autowired
	private IGrnService service;
	
	@Autowired
	private IPurchaseService purService;
	
	void addChildToUi(ModelMap map){
		List<Object[]> list=purService.getIdAndCode();
		Map<Integer, String> purchasemap=CommonUtil.convertData(list);
		map.addAttribute("purchase", purchasemap);
	}
	
	
	@RequestMapping("/reg")
	public String showGrn(ModelMap map) {
		map.addAttribute("grn", new Grn());
		addChildToUi(map);
		return "GrnRegister";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveGrn(@ModelAttribute Grn grn,ModelMap map) {
		Integer id=service.saveGrn(grn);
		String msg="Grn '"+id+"' Saved Successfully";
		addChildToUi(map);
		map.addAttribute("msg",msg);
		map.addAttribute("grn", new Grn());
		return "GrnRegister";
	}
	@RequestMapping("/all")
	public String allGrn(ModelMap map) {
		List<Object[]> list=service.viewGrns();
		map.addAttribute("list", list);
		return "GrnData";
	}
	@RequestMapping("/delete")
	public String deleteGrn(@RequestParam Integer id, ModelMap map) {
		service.deleteGrn(id);
		String msg="Grn With ID '"+id+"' Deleted successfully";
		List<Object[]> list=service.viewGrns();
		map.addAttribute("msg", msg);
		map.addAttribute("list", list);
		return "GrnData";
	}
	@RequestMapping("/edit")
	public String editGrn(@RequestParam Integer id, ModelMap map) {
		Grn grn=service.getOneGrn(id);
		addChildToUi(map);
		map.addAttribute("Grn",grn);
		return "GrnEdit";
	}
	@RequestMapping("/update")
	public String updateGrn(@ModelAttribute Grn grn, ModelMap map) {
		service.updateGrn(grn);
		String msg="Grn '"+grn.getId()+"' Updated Successfully";
		map.addAttribute("msg",msg);
		List<Object[]> list=service.viewGrns();
		map.addAttribute("list", list);
		return "GrnData";
	}
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id, ModelMap map) {
		Grn grn=service.getOneGrn(id);
		map.addAttribute("grn",grn);
		return "GrnView";
	}
	@RequestMapping("/excel")
	public ModelAndView excelExport(@RequestParam(required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		List<Grn> grn=null;
		if(id==null) {
			grn=service.getAllGrns();
		}else {
			grn=Arrays.asList(service.getOneGrn(id));
		}
		m.setView(new GrnExcelView());
		m.addObject("list", grn);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(required = false)Integer id) {
		List<Grn> grn=null;
		if(id==null)
			grn=service.getAllGrns();
		else
			grn=Arrays.asList(service.getOneGrn(id));
		ModelAndView m=new ModelAndView();
		m.setView(new GrnPdfView());
		m.addObject("list",grn);
		return m;
	}
}
