package com.learn.app.perpustakaan.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.app.perpustakaan.dao.PinjamDao;
import com.learn.app.perpustakaan.dao.PinjamHDao;
import com.learn.app.perpustakaan.model.Pinjam;
import com.learn.app.perpustakaan.model.PinjamD;

@Service
public class PinjamServiceImpl implements PinjamService{
	
	@Autowired
	PinjamDao pd;
	
	@Autowired
	PinjamHDao phd;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public PinjamD save(PinjamD pinjamD) throws ParseException {
		Pinjam pinjam = phd.save(new Pinjam());
		pinjamD.setId_pinjam(pinjam.getId());
		return pd.save(pinjamD);
	}

	@Override
	public PinjamD findOne(String id) {
		return pd.findOne(id);
	}

	@Override
	public Iterable<PinjamD> findAll() {
		 return pd.findAll();
	}

}
