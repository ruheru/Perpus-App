/**
 * 
 */
package com.learn.app.perpustakaan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learn.app.perpustakaan.dao.MahasiswaDao;
import com.learn.app.perpustakaan.model.Mahasiswa;
import com.learn.app.perpustakaan.service.MahasiswaService;


/**
 * @author Ridhfirmans
 *
 * @created date Jul 8, 2018
 * Keep learning, you can do it!
 */

@Controller
@RequestMapping("/mahasiswa")
public class MahasiwaController {
	@Autowired
	MahasiswaDao mhsDao;
	
	@Autowired
	MahasiswaService mhsService;
	
	@RequestMapping("/list-mahasiswa")
	public void listMahasiswa(Model mod){
		mod.addAttribute("list_mahasiswa", mhsDao.findAll());
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String viewForm(@RequestParam(value="id", required=false) String id, Model m){
		List<String> listDummy = new ArrayList<>();
		listDummy.add("Gojek");
		listDummy.add("Blibli");
		listDummy.add("Tiket");
		
		m.addAttribute("listGG", listDummy);
		m.addAttribute("mahasiswa", new Mahasiswa());
		if(id != null && !id.isEmpty()){
			Mahasiswa mhs = mhsDao.findOne(id);
			if(mhs != null){
				m.addAttribute("mahasiswa", mhs);
			}
		}
		return "/mahasiswa/form-mahasiswa";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String saveMahasiswa(@Valid Mahasiswa mhs, BindingResult errors, final RedirectAttributes redirectAttributes) {
		if(errors.hasErrors()){
			redirectAttributes.addFlashAttribute("saveMahasiswa","unsuccess");
			System.out.println("ada error mahasiswa");
		}else{
			mhsDao.save(mhs);
			System.out.println("sukses save mahasiswa");
			return "redirect:list-mahasiswa";
		}
		return "/mahasiswa/form-mahasiswa";
	}
	
	@RequestMapping("/hapus")
	public String deleteMahasiswa(@RequestParam("ad") String id){
		mhsDao.delete(id);
		return "redirect:list-mahasiswa";
	}
	
	/*@RequestMapping(value="/form")
	public String mahasiswa(Map<String, Object> model) {
		try {
			Map<String, String> sampleDropdownMap = new HashMap<String, String>();
			sampleDropdownMap.put("Java", "java");
			sampleDropdownMap.put("PHP", "php");
			model.put("dropDownItems", sampleDropdownMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/mahasiswa/form-mahasiswa";
	}*/
	
	/*@RequestMapping("/form")
	public ModelAndView showMessage() {
		System.out.println("----Masuk sini----");
		ModelAndView model = null;
		try {
			Map<String, String> sampleDropdownMap = new HashMap<String, String>();
			sampleDropdownMap.put("Java", "java");
			sampleDropdownMap.put("PHP", "php");
			model = new ModelAndView("form-mahasiswa", "dropDownItems", sampleDropdownMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}*/
	
}
