package com.learn.app.perpustakaan.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.app.perpustakaan.dao.BukuDao;
import com.learn.app.perpustakaan.model.PinjamD;
import com.learn.app.perpustakaan.service.MahasiswaService;
import com.learn.app.perpustakaan.service.PinjamService;

@Controller
@RequestMapping("/pinjam")
public class PinjamController {

	@Autowired
	private PinjamService ps;
	
	@Autowired
	MahasiswaService mahasiswaService;
	
	@Autowired
	BukuDao bukuDao;
	
	@RequestMapping("/list-pinjam")
	public void daftarPinjam(Model mod) {
		mod.addAttribute("listPinjam", ps.findAll());
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String viewForm(@RequestParam(value="id", required=false) String id,
			Model m) {
		m.addAttribute("listBuku", bukuDao.findAll());
		m.addAttribute("listMahasiswa", mahasiswaService.findAll());
		m.addAttribute("pinjam", new PinjamD());
		
		if(id != null && !id.isEmpty()) {
			PinjamD pinD = ps.findOne(id);
			if(pinD != null) {
				m.addAttribute("pinjam", pinD);
			}
		}
		return "/pinjam/form-pinjam";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String savePinjam(@Valid PinjamD pinD, BindingResult errors) {
		if(!errors.hasErrors()) {
			pinD.setId_status("belom balik");
			try {
				ps.save(pinD);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return "redirect:list-pinjam";
		}
		return "redirect:list-pinjam";
	}
}
