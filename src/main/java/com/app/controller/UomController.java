package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtil util;
	
	//1.Show Register Page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	
	//2. Save Data On Click submit
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom, ModelMap map) {
		
		//Call Service Layer
		Integer id=service.saveUom(uom);
		//Construct success Message
		String message ="Uom'"+id+"'Created";
		//Send message to UI
		map.addAttribute("msg", message);
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	
	//3. To get all the table data
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		//Make Service layer call
		List<Uom> lst=service.getAllUoms();
		
		//send data to ui
		map.addAttribute("list",lst);
		
		return "UomData";
	}
	
	//4. Delete Uom by ID
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id, ModelMap map) {
		//call service
		service.deleteUom(id);
		
		//get new data
		List<Uom> uoms=service.getAllUoms();
		//Success msg
		String msg="Deleted'"+id+"'Successfully;";
		//send to UI
		map.addAttribute("list",uoms);
		map.addAttribute("msg",msg);
				
		return "UomData";
	}
	
	//5. Show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		//call service
		Uom u=service.getOneUom(id);
		map.addAttribute("uom",u);
		return "UomEdit";
	}
	
	//6. update
	@RequestMapping("/update")
	public String update(@ModelAttribute Uom uom,ModelMap map) {
		service.updateUom(uom);
		String message="Uom '"+uom.getId()+"' Updated Successfully";
		map.addAttribute("msg",message);
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("list", uoms);
		return "redirect:all";
	}
	
	//7. View One Page
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id, ModelMap map) {
		Uom uom=service.getOneUom(id);
		map.addAttribute("ob",uom);
		return "UomView";
	}
	
	//8. Excel View
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required=false)Integer id) {
		List<Uom> uoms=null;
		if(id==null) {
			uoms=service.getAllUoms();
		}else {
			uoms=Arrays.asList(service.getOneUom(id));
		}
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		m.addObject("list",uoms);
		return m;
	}
	
	//9.Export to pdf
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(required = false)Integer id) {
		List<Uom> uoms=null;
		if(id==null)
			uoms=service.getAllUoms();
		else
			uoms=Arrays.asList(service.getOneUom(id));
		//Read data from DB
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		m.addObject("list",uoms);
		return m;
	}
	
//	10. Generate Charts
	@RequestMapping("/charts")
	public String genChart() {
		List<Object[]> list= service.getUomTypeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		util.genBar(path, list);
		return "UomCharts";
	}
}