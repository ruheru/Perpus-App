package com.learn.app.perpustakaan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learn.app.perpustakaan.dao.PenerbitDao;
import com.learn.app.perpustakaan.model.Penerbit;

@Controller
@RequestMapping("/penerbit")
public class PenerbitController {
	
	@Autowired
	PenerbitDao pd;
	
	@RequestMapping("/list-penerbit")
	public void daftarPenerbit(Model m) {
		m.addAttribute("list_penerbit",pd.findAll());
	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String viewForm(@RequestParam(value="id", required=false) String id
			,Model m) {
		m.addAttribute("penerbit", new Penerbit());
		if(id != null && !id.isEmpty()) {
			Penerbit pen = pd.findOne(id);
			if(pen != null) {
				m.addAttribute("penerbit", pen);
			}
		}
		return "/penerbit/form-penerbit";
	}
	
	@RequestMapping(value = "/form", method= RequestMethod.POST)
	public String savePenerbit(@Valid Penerbit pen, BindingResult errors,
			final RedirectAttributes redirectAttributes) {
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("savePenerbit","unsuccess");
			System.out.println("ada error");
//			return "/penerbit/form-penerbit";
		}else {
			pd.save(pen);
			System.out.println("sukses save");
			return "redirect:list-penerbit";
		}
		return "/penerbit/form-penerbit";
	}
	
	@RequestMapping("/hapus")
	public String deletePenerbit(@RequestParam("ad") String id) {
		pd.delete(id);
		return "redirect:list-penerbit";
	}
	

}
