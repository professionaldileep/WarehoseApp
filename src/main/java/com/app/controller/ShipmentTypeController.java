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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	
	//1.Show Register Page
		@RequestMapping("/reg")
		public String showReg(ModelMap map) {
			map.addAttribute("shipmentType", new ShipmentType());
			return "ShipmentTypeRegister";
		}
		
		//2. Save Data On Click submit
		@RequestMapping(value="/save", method = RequestMethod.POST)
		public String saveData(@ModelAttribute ShipmentType st, ModelMap map) {
			
			//Call Service Layer
			Integer id=service.saveShipmentType(st);
			//Construct success Message
			String message ="ShipmentType'"+id+"'Created";
			//Send message to UI
			map.addAttribute("msg", message);
			map.addAttribute("shipmentType", new ShipmentType());
			return "ShipmentTypeRegister";
		}
		
		//3. to get all the table data
		@RequestMapping("/all")
		public String getAll(ModelMap map) {
			//Make Service layer call
			List<ShipmentType> list=service.getAllShipmentTypes();
			
			//send data to ui
			map.addAttribute("list",list);
			return "ShipmentTypeData";
		}
		
//		4.Delete ShipmentType by ID
		@RequestMapping("/delete")
		public String delete(@RequestParam Integer id,ModelMap map) {
//			call service
			service.deleteShipmentType(id);
//			get new data
			List<ShipmentType> shipTypes=service.getAllShipmentTypes();
//			success message
			String msg="Deleted '"+id+"'Successfully";
			
			map.addAttribute("list", shipTypes);
			map.addAttribute("msg",msg);
			return "ShipmentTypeData";
		}
		
//		5.Edit ShipmentType by ID
		@RequestMapping("/edit")
		public String showEdit(@RequestParam Integer id,ModelMap map) {
//			Call Service
			ShipmentType st=service.getOneShipmentType(id);
//			TO UI
			map.addAttribute("shipmentType",st);
			return "ShipmentTypeEdit";
		}
		
//		6.Update ShipmentType
		@RequestMapping("/update")
		public String update(@ModelAttribute ShipmentType st,ModelMap map) {
			service.updateShipmentType(st);
			String msg="ShipmentType'"+st.getId()+"'Updated Successfully";
			List<ShipmentType> list=service.getAllShipmentTypes();
			map.addAttribute("list",list);
			map.addAttribute("msg",msg);
			return "ShipmentTypeData";
		}
//		7. To view ShipmentType
		@RequestMapping("/view")
		public String getOne(@RequestParam Integer id, ModelMap map) {
			ShipmentType st=service.getOneShipmentType(id);
			map.addAttribute("ob",st);
			return "ShipmentTypeView";
		}
		
//		8.Excel View
		@RequestMapping("/excel")
		public ModelAndView exportExcel(@RequestParam(required=false)Integer id) {
			List<ShipmentType> st=null;
			if(id==null)
				st=service.getAllShipmentTypes();
			else
				st=Arrays.asList(service.getOneShipmentType(id));
			
			ModelAndView m=new ModelAndView();
			m.setView(new ShipmentTypeExcelView());
			m.addObject("list",st);
			return m;
		}
//		9. Pdf View
		@RequestMapping("/pdf")
		public ModelAndView exportPdf(@RequestParam(required=false)Integer id) {
			List<ShipmentType> st=null;
			if(id==null)
				st=service.getAllShipmentTypes();
			else
				st=Arrays.asList(service.getOneShipmentType(id));
			ModelAndView m=new ModelAndView();
			m.setView(new ShipmentTypePdfView());
			m.addObject("list",st);
			return m;
		}
}
