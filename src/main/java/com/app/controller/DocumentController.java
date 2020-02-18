package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping(value = {"/document","/doc2"})
public class DocumentController {

	@Autowired
	private IDocumentService service;

	//	Show Documents Page
	@RequestMapping("/reg")
	public String showDoc(ModelMap map){


		List<Object[]> list=service.getDocumentIdAndName();
		map.addAttribute("list",list);

		return "Documents";
	}

	//	On Click Update
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadDoc(@RequestParam Integer fid,
			@RequestParam CommonsMultipartFile fdoc) {
		if(fdoc!=null) {
			Document doc=new Document();
			doc.setFileId(fid);
			doc.setFileName(fdoc.getOriginalFilename());
			doc.setFileData(fdoc.getBytes());
			service.saveDocument(doc);
		}

		return "redirect:reg";
	}

	@RequestMapping("/download")
	public void downloadDoc(@RequestParam Integer fid, HttpServletResponse resp){
		Document doc=service.getOneDocument(fid);

		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());

		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
