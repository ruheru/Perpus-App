package com.learn.app.perpustakaan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.app.perpustakaan.dao.BukuDao;
import com.learn.app.perpustakaan.dao.PenerbitDao;
import com.learn.app.perpustakaan.model.Buku;

@Controller
@RequestMapping("/buku")
public class BukuController {
	@Autowired BukuDao bd;
	@Autowired PenerbitDao pd;
	
	@RequestMapping("/list-buku")
	public void listBuku(Model mod) {
		mod.addAttribute("listBuku", bd.findAll());
	}
	
	@RequestMapping(value ="/form", method=RequestMethod.GET)
	public String viewForm(@RequestParam(value="id", required=false) String id, Model mod) {
		mod.addAttribute("mapPenerbit", pd.findAll());
		mod.addAttribute("buku",new Buku());
		if(null != id && !id.isEmpty()) {
			Buku buku = bd.findOne(id);
			if(null != buku) {
				mod.addAttribute("buku",buku);
			}
		}
		return "/buku/form-buku";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String saveBuku(@Valid Buku buk,BindingResult errors) {
		if(!errors.hasErrors()) {
			bd.save(buk);
			System.out.println("sukses save==============");
			return "redirect:list-buku";
		}
		return "/buku/form-buku";
	}
	
	@RequestMapping("/hapus")
	public String deleteBuku(@RequestParam("aidi") String id) {
		bd.delete(id);
		return "redirect:list-buku";
	}
}
