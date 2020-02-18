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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.EmailUtil;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whusertype")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private EmailUtil emailUtil;
	
//	1.Show Register Page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserRegister";
	}
	
//	2.Save to Register Page
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveWhUser(@ModelAttribute WhUserType whUserType, @RequestParam CommonsMultipartFile fileDoc, ModelMap map) {
//		Call Service Method
		map.addAttribute("whUserType", new WhUserType());
		Integer id=service.saveWhUser(whUserType);
//		Construct the message
		String msg="WhUser '"+id+"' Saved";
		
		if(id!=null) {
			String text = "Hello:"+whUserType.getUserCode()+
					", You are: "+whUserType.getUserType()
					+", You can have:"+whUserType.getUserFor();
			boolean isSent = emailUtil.send(whUserType.getUserEmail(), "Welcome TO WareHouse App ", text, fileDoc.getSize()!=0?fileDoc:null);
			if(isSent)
				msg+=", Email also sent";
			else 
				msg+=", Email Sending failed";
		}
		
		
//		Send data to UI
		map.addAttribute("msg",msg);
		return "WhUserRegister";
	}
	
//	3.View Rows in Data Page
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		List<Object[]> list=service.viewWhUsers();
		map.addAttribute("list",list);
		return "WhUserData";
	}
	
//	4. Delete One WhUser by ID
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id, ModelMap map) {
		service.deleteWhUser(id);
		String msg="WhUser '"+id+"' Deleted Successfully";
		
		List<Object[]> list=service.viewWhUsers();
		map.addAttribute("msg",msg);
		map.addAttribute("list",list);
		return "WhUserData";
	}
//	5. Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,ModelMap map) {
		WhUserType wh=service.getOneWhUser(id);
		map.addAttribute("wh", wh);
		return "WhUserEdit";
	}
	
//	6. Update WhUser
	@RequestMapping("/update")
	public String update(@ModelAttribute WhUserType wh, ModelMap map) {
		service.updateWhUser(wh);
		String msg="Updated '"+wh.getId()+"' Successfully";
		List<Object[]> list=service.viewWhUsers();
		map.addAttribute("msg",msg);
		map.addAttribute("list", list);
		return "WhUserData";
	}
//	7.View One
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id, ModelMap map) {
		WhUserType wh=service.getOneWhUser(id);
		map.addAttribute("ob", wh);
		return "WhUserView";
	}
//	8. Excel View
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required = false) Integer id) {
		List<WhUserType> list=null;
		if(id==null) {
			list=service.getAllWhUsers();
		}else {
			WhUserType wh=service.getOneWhUser(id);
			list=Arrays.asList(wh);
		}
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		m.addObject("list",list);
		return m;
	}
	
//	9.export to pdf
	@RequestMapping("/pdf")
	public ModelAndView exportPdf(@RequestParam(required = false)Integer id) {
		List<WhUserType> list=null;
		if(id==null)
			list=service.getAllWhUsers();
		else
			list=Arrays.asList(service.getOneWhUser(id));
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		m.addObject("list",list);
		return m;
	}
}
